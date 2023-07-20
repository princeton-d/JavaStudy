package princeton.securitytest.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import princeton.securitytest.member.domain.role.Role;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private static final String TOKEN_TYPE = "Bearer ";

    private final Key secretKey;
    private final long TOKEN_EXPIRES_IN;
    private final String AUTHORIZATION_KEY = "auth";

    public JwtProvider(
            @Value("${jwt.secret.key}") final String secretKey,
            @Value("${jwt.expire.length}") final long tokenExpiresIn
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.TOKEN_EXPIRES_IN = tokenExpiresIn;
    }

    public String createAccessToken(final Long id, final Role role) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + TOKEN_EXPIRES_IN);

        return Jwts.builder()
                .setSubject(id.toString())
                .setIssuedAt(now)
                .setExpiration(validity)
                .claim(AUTHORIZATION_KEY, role)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {

        try {
            return getClaimsJws(token)
                    .getBody()
                    .getExpiration()
                    .after(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getRole(final String token) {
        String roleValue = getClaimsJws(token)
                .getBody()
                .get(AUTHORIZATION_KEY, String.class);

        return Role.valueOf(roleValue).getValue();
    }

    public Long getId(final String token) {
        String idValue = getClaimsJws(token)
                .getBody()
                .getSubject();

        return Long.parseLong(idValue);
    }

    private Jws<Claims> getClaimsJws(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }

    private String extractToken(String token) {
        if (isInvalidTokenType(token)) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

        return token.substring(TOKEN_TYPE.length());
    }

    private boolean isInvalidTokenType(String token) {
        return token == null || !token.startsWith(TOKEN_TYPE);
    }

}