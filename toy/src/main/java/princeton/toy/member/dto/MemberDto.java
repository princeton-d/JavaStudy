package princeton.toy.member.dto;

import lombok.Getter;
import princeton.toy.member.domain.entity.Member;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private String loginId;
    private String email;
    private LocalDateTime createdAt;

    public MemberDto(Member member) {
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.createdAt = member.getCreatedAt();
    }
}
