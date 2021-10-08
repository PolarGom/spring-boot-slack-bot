package com.example.demo.common.adapter;

import com.example.demo.common.dto.request.RequestBotMessage;
import com.example.demo.slack.bot.dto.request.RequestEventSub;

/**
 * 봇 어댑터 인터페이스
 */
public interface IBotAdapter<T> {

    /**
     * 메세지 전송
     * 
     * @param requestBotMessage 전송 할 메세지 정보
     */
    void dispatch(RequestBotMessage requestBotMessage);

    /**
     * 메세지 전송 전처리
     * 
     * @param t 각 봇의 메세지 정보
     */
    void onMessage(T t);
}
