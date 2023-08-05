package com.princeton.userservice.dto.request;

import lombok.*;

import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class RequestMemberSignupDto {

    private String email;
    private String name;
    private String password;

}
