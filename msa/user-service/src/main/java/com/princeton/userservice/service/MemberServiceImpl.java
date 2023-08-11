package com.princeton.userservice.service;

import com.princeton.userservice.dto.Response.ResponseMemberSignupResultDto;
import com.princeton.userservice.dto.request.RequestMemberSignupDto;
import com.princeton.userservice.entity.Member;
import com.princeton.userservice.global.response.ResponseDataDto;
import com.princeton.userservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.princeton.userservice.mapper.MemberMapper.*;
import static org.springframework.http.HttpMethod.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final Environment environment;

    private final RestTemplate restTemplate;

    @Override
    @Transactional
    public ResponseMemberSignupResultDto createMember(RequestMemberSignupDto requestMemberSignupDto) {
        String userId = UUID.randomUUID().toString();

        Member member = INSTANCE.requestMemberSignupDtoToEntity(requestMemberSignupDto, userId);
        Member savedMember = memberRepository.save(member);

        String catalogUrl = String.format(environment.getProperty("catalog-service.test-url"), 134);

        ResponseDataDto<HashMap<Integer, String>> body = restTemplate.exchange(catalogUrl, GET, null, new ParameterizedTypeReference<ResponseDataDto<HashMap<Integer, String>>>() {
        }).getBody();

        HashMap<Integer, String> data = body.getData();

        System.out.println(data.toString());

        return INSTANCE.entityToResponseMemberSignupResultDto(savedMember);
    }
}
