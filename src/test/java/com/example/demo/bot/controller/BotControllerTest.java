package com.example.demo.bot.controller;

import com.example.demo.CommonControllerTest;
import com.example.demo.bot.dto.request.RequestUrlVerify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 슬랙 봇 컨트롤러 테스트
 */
public class BotControllerTest extends CommonControllerTest {

    @Test
    @DisplayName("슬랩 봇 URL Verify 테스트" )
    public void testUrlVerify() throws Exception {

        String type = "url_verification";
        String token = "dummy_token";
        String challenge = "dummy_challenge";

        String content = this.jsonObjectMapper.writeValueAsString(
                RequestUrlVerify.builder().type(type).token(token).challenge(challenge).build());

        this.mockMvc.perform(post("/api/bot")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.challenge", equalTo(challenge)))
                .andReturn();
    }
}