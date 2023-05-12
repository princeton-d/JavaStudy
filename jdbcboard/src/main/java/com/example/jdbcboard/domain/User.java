package com.example.jdbcboard.domain;

import com.example.jdbcboard.controller.UserForm;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String nickname;
    private String email;
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User setUserInfo(UserForm form) {
        this.nickname = form.getNickname();
        this.email = form.getEmail();
        this.password = form.getPassword();
        this.createdAt = LocalDateTime.now();

        return this;
    }
}
