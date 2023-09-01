package com.princeton.userservice.dto.request;

import lombok.*;

import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class RequestMemberSignupDto {

    private String email;
    private String name;
    private String password;

}
