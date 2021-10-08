package com.example.demo.slack.bot.controller;

import com.example.demo.common.adapter.IBotAdapter;
import com.example.demo.slack.bot.dto.request.RequestEventSub;
import com.example.demo.slack.bot.dto.response.ResponseUrlVerify;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 슬랙 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SlackController {

    private final IBotAdapter slackBotAdapterImpl;

    /**
     * 슬랙 구독 알림 이벤트
     * 
     * @param requestEventSub 이벤트 구독 정보
     * @return result challenge 정보
     */
    @PostMapping("/bot")
    public ResponseEntity<ResponseUrlVerify> subscribe(@RequestBody RequestEventSub requestEventSub) {

        log.info("[Bot] bot request info: {}", requestEventSub.toString());

        slackBotAdapterImpl.onMessage(requestEventSub);

        return ResponseEntity.ok(ResponseUrlVerify.builder().challenge(requestEventSub.getChallenge()).build());
    }
}
