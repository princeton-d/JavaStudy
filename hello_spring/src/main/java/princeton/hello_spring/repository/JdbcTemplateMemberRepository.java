//package princeton.hello_spring.repository;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import princeton.hello_spring.domain.Member;
//import princeton.hello_spring.exception.AlreadyRegisteredException;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//public class JdbcTemplateMemberRepository implements MemberRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Member save(Member member, String name) {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("name", name);
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        Member createMember = Member.builder().id(key.longValue()).name(name).build();
//        return createMember;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        String query = "select * from member where id = ?";
//        List<Member> result = jdbcTemplate.query(query, memberRowMapper(), id);
//
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        String query = "select * from member";
//        return jdbcTemplate.query(query, memberRowMapper());
//    }
//
//    private RowMapper<Member> memberRowMapper() {
//        return (rs, rowNum) -> Member.builder()
//                .id(rs.getLong("id"))
//                .name(rs.getString("name"))
//                .build();
//    }
//
//}
