package princeton.hello_spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import princeton.hello_spring.controller.form.MemberForm;
import princeton.hello_spring.domain.Member;
import princeton.hello_spring.exception.AlreadyRegisteredException;
import princeton.hello_spring.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(@ModelAttribute MemberForm memberForm) {
        Member member = Member.builder()
                .name(memberForm.getName())
                .build();

        memberService.join(member, memberForm.getName());

        return "redirect:/members";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findAllMembers();

        model.addAttribute("members", members);

        return "members/memberList";
    }
}
