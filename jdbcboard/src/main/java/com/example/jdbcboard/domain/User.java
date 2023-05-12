package com.example.jdbcboard.domain;

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

    public void pushCreatedAt() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
