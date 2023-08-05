package com.princeton.userservice.service;

import com.princeton.userservice.dto.Response.ResponseMemberSignupResultDto;
import com.princeton.userservice.dto.request.RequestMemberSignupDto;

public interface MemberService {

    ResponseMemberSignupResultDto createMember(RequestMemberSignupDto requestMemberSignupDto);

}
