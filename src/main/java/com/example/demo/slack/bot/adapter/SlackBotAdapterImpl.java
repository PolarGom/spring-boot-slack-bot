package com.example.demo.slack.bot.adapter;

import com.example.demo.common.adapter.IBotAdapter;
import com.example.demo.common.dto.request.RequestBotMessage;
import com.example.demo.common.exception.CommonException;
import com.example.demo.slack.bot.SlackClient;
import com.example.demo.slack.bot.dto.request.RequestEventSub;
import com.example.demo.slack.bot.exception.SlackAdapterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 슬랙 어댑터 구현체
 *
 * @see {@link IBotAdapter}
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SlackBotAdapterImpl implements IBotAdapter<RequestEventSub> {

    private final SlackClient slackClient;

    @Override
    public void dispatch(RequestBotMessage requestBotMessage) {

        slackClient.sendMessage(requestBotMessage);
    }

    @Override
    public void onMessage(RequestEventSub requestEventSub) {

        try {

            if ( !StringUtils.hasText(requestEventSub.getEvent().getClientMsgId()) && !StringUtils.hasText(requestEventSub.getChallenge()) ) {

                RequestBotMessage botMessage = RequestBotMessage.builder()
                        .room(requestEventSub.getEvent().getChannel())
                        .message(String.format("Echo: %s", requestEventSub.getEvent().getText()))
                        .build();

                this.dispatch(botMessage);
            }
        } catch ( CommonException e ) {

            throw e;
        } catch ( Exception e ) {

            throw new SlackAdapterException(e, "슬랙 봇 메시지 전송 준비 중 오류가 발생하였습니다.");
        }
    }
}
