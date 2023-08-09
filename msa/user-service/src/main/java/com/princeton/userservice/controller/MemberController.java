package com.princeton.userservice.controller;

import com.princeton.userservice.dto.Response.ResponseMemberSignupResultDto;
import com.princeton.userservice.dto.request.RequestMemberSignupDto;
import com.princeton.userservice.global.response.ResponseDataDto;
import com.princeton.userservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class MemberController {

    private final Environment env;

    private final MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return env.getProperty("token.expiration_time");
    }

    @PostMapping("/members")
    public ResponseEntity<ResponseDataDto<ResponseMemberSignupResultDto>> createMember(@RequestBody RequestMemberSignupDto requestMemberSignupDto) {
        ResponseMemberSignupResultDto responseDto = memberService.createMember(requestMemberSignupDto);

        return ResponseEntity.status(CREATED).body(new ResponseDataDto<>(responseDto));
    }

}
