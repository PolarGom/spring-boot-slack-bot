package com.example.demo.bot.controller;

import com.example.demo.bot.dto.request.RequestUrlVerify;
import com.example.demo.bot.dto.response.ResponseUrlVerify;
import com.example.demo.common.dto.response.ResponseResult;
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

    @PostMapping("/bot")
    public ResponseEntity<ResponseUrlVerify> urlVerify(@RequestBody RequestUrlVerify requestUrlVerify) {

        log.info("[Bot] bot url verify request info: {}", requestUrlVerify.toString());

        return ResponseEntity.ok(ResponseUrlVerify.builder().challenge(requestUrlVerify.getChallenge()).build());
    }
}
