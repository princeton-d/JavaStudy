package princeton.toy.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.dto.MemberAndArticleDto;
import princeton.toy.member.dto.MemberDto;
import princeton.toy.member.dto.MemberListDto;
import princeton.toy.member.service.MemberService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Member> memberList = new ArrayList<>();

        memberList.add(member1);
        memberList.add(member2);

        List<MemberDto> memberDtoList = memberList.stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());

        when(memberService.findMembersDto()).thenReturn(new MemberListDto(memberDtoList));

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.members", hasSize(2)))
                .andExpect(jsonPath("$.members[0].loginId").exists())
                .andExpect(jsonPath("$.members[0].email").exists())
                .andExpect(jsonPath("$.members[0].createdAt").exists())
                .andExpect(jsonPath("$.members[1].loginId").value("loginId2"))
                .andExpect(jsonPath("$.members[1].email").value("email2"));
    }

    @Test
    public void getMember() throws Exception {
        //given
        Member member = new Member("loginId", "email", LocalDateTime.now(), "password");
        Article article1 = new Article(member, "title1", "content1", LocalDateTime.now());
        Article article2 = new Article(member, "title2", "content2", LocalDateTime.now());

        member.addArticle(article1);
        member.addArticle(article2);

        List<Article> articles = member.getArticles();

        //when
        when(memberService.findMemberByLoginId("loginId")).thenReturn(new MemberAndArticleDto(member, articles));

        //then
        mockMvc.perform(get("/member/{id}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.member[0].loginId").exists())
                .andExpect(jsonPath("$.member[0].email").exists())
                .andExpect(jsonPath("$.member[0].createdAt").exists())
                .andExpect(jsonPath("$.member[0].articles").exists())
                .andExpect(jsonPath("$.member[0].articles", hasSize(2)))
                .andExpect(jsonPath("$.member[0].articles[0].articleId").exists())
                .andExpect(jsonPath("$.member[0].articles[0].title").exists())
                .andExpect(jsonPath("$.member[0].articles[0].createdAt").exists())
                .andExpect(jsonPath("$.member[0].articles[1].title").value("title2"));
    }

}