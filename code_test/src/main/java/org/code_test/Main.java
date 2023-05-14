package org.code_test;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Member member = new Member.Builder()
                .id(1L)
                .name("박보검")
                .createdAt(LocalDateTime.now())
                .address("대구광역시 동구 서호동")
                .password("password")
                .email("princeton@gmail.com")
                .build();
    }
}
