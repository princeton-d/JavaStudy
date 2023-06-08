package princeton.toy.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.service.MemberService;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void getMemberList() throws Exception {

        Member member1 = new Member("loginId1", "email1", LocalDateTime.now(), "password1");
        Member member2 = new Member("loginId2", "email2", LocalDateTime.now(), "password2");
        when(memberService.join(member1)).thenReturn(1L);
        when(memberService.join(member2)).thenReturn(2L);

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.members", hasSize(2)));

    }

}