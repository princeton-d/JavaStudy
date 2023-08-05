package com.princeton.userservice.mapper;

import com.princeton.userservice.dto.Response.ResponseMemberSignupResultDto;
import com.princeton.userservice.dto.request.RequestMemberSignupDto;
import com.princeton.userservice.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member requestMemberSignupDtoToEntity(RequestMemberSignupDto requestMemberSignupDto, String userId);

    ResponseMemberSignupResultDto entityToResponseMemberSignupResultDto(Member member);

}
