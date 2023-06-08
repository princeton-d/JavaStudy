package princeton.toy.member.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MemberListDto {

    private List<MemberDto> members;

    public MemberListDto(List<MemberDto> members) {
        this.members = members;
    }
}
