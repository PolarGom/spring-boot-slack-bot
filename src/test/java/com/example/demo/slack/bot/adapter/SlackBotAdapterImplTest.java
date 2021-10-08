package com.example.demo.slack.bot.adapter;

import com.example.demo.common.adapter.IBotAdapter;
import com.example.demo.slack.bot.SlackClient;
import com.example.demo.slack.bot.dto.request.RequestEvent;
import com.example.demo.slack.bot.dto.request.RequestEventSub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

/**
 * 슬랫 봇 어댑터 구현체 테스트
 */
public class SlackBotAdapterImplTest {

    private IBotAdapter slackBotAdapterImpl;

    @Mock
    private SlackClient slackClient;

    private final String token = "xxox";

    @BeforeEach
    public void setUp() {

        slackClient = mock(SlackClient.class);
    }

    @Test
    @DisplayName("슬랙 봇 어댑터 메세지 전송 테스트")
    public void testOnMessage() {

        RequestEventSub requestEventSub = RequestEventSub.builder()
                .event(RequestEvent.builder().channel("channel").text("message").build())
                .build();

        slackBotAdapterImpl = new SlackBotAdapterImpl(slackClient);
        slackBotAdapterImpl.onMessage(requestEventSub);
    }
}
