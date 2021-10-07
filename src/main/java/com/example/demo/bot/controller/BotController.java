package com.example.demo.bot.controller;

import com.example.demo.bot.dto.request.RequestEventSub;
import com.example.demo.bot.dto.response.ResponseUrlVerify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 슬랙 봇 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class BotController {

    /**
     * 슬랙 구독 알림 이벤트
     * 
     * @param requestEventSub 이벤트 구독 정보
     * @return result challenge 정보
     */
    @PostMapping("/bot")
    public ResponseEntity<ResponseUrlVerify> subscribe(@RequestBody RequestEventSub requestEventSub) {

        log.info("[Bot] bot request info: {}", requestEventSub.toString());

        return ResponseEntity.ok(ResponseUrlVerify.builder().challenge(requestEventSub.getChallenge()).build());
    }
}
