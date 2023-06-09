package princeton.toy.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.dto.MemberDto;
import princeton.toy.member.dto.MemberListDto;
import princeton.toy.member.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/members")
    public MemberListDto members() {
        return memberService.findMembersDto();
    }

}
