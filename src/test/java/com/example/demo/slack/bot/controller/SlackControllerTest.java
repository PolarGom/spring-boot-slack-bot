package com.example.demo.slack.bot.controller;

import com.example.demo.CommonControllerTest;
import com.example.demo.slack.bot.dto.request.RequestEventSub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 슬랙 봇 컨트롤러 테스트
 */
public class SlackControllerTest extends CommonControllerTest {

    @Test
    @DisplayName("슬랩 봇 URL Verify 테스트" )
    public void testSubscribe() throws Exception {

        String type = "url_verification";
        String token = "dummy_token";
        String challenge = "dummy_challenge";

        String content = this.jsonObjectMapper.writeValueAsString(
                RequestEventSub.builder().type(type).token(token).challenge(challenge).build());

        this.mockMvc.perform(post("/api/bot")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.challenge", equalTo(challenge)))
                .andReturn();
    }
}