package princeton.princeton.member.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import princeton.princeton.team.entity.Team;

import static org.assertj.core.api.Assertions.*;

class MemberTest {

    @Test
    public void changeTeamTest() throws Exception {
        //given
        Member member = new Member("memberA", 20, null);
        Team team = new Team("teamA");

        //when
        member.changeTeam(team);

        //then
        assertThat(member.getTeam()).isNotNull();
        assertThat(member.getTeam()).isEqualTo(team);
        assertThat(team.getMembers().get(0)).isEqualTo(member);
    }

}