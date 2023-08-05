package com.princeton.userservice.service;

import com.princeton.userservice.dto.Response.ResponseMemberSignupResultDto;
import com.princeton.userservice.dto.request.RequestMemberSignupDto;
import com.princeton.userservice.entity.Member;
import com.princeton.userservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.princeton.userservice.mapper.MemberMapper.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public ResponseMemberSignupResultDto createMember(RequestMemberSignupDto requestMemberSignupDto) {
        String userId = UUID.randomUUID().toString();

        Member member = INSTANCE.requestMemberSignupDtoToEntity(requestMemberSignupDto, userId);
        Member savedMember = memberRepository.save(member);

        return INSTANCE.entityToResponseMemberSignupResultDto(savedMember);
    }
}
