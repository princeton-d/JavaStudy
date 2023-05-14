package org.code_test;

import java.time.LocalDateTime;

public class Member {
    private final Long id;
    private final String name;
    private final String email;
    private final String nickname;
    private final String password;
    private final String address;
    private final LocalDateTime createdAt;

    public Member(Long id, String name, String email, String nickname, String password, String address, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.address = address;
        this.createdAt = createdAt;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String nickname;
        private String password;
        private String address;
        private LocalDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Member build() {
            return new Member(id, name, email, nickname, password, address, createdAt);
        }
    }
}
