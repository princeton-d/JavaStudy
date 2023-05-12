package com.example.jdbcboard.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long userId;
    private String nickName;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(String nickName, String email, String password, LocalDateTime createdAt) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}
