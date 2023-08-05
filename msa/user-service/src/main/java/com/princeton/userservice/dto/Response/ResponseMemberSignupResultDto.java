package com.princeton.userservice.dto.Response;

import lombok.*;

import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class ResponseMemberSignupResultDto {

    private String email;
    private String name;
    private String userId;

}
