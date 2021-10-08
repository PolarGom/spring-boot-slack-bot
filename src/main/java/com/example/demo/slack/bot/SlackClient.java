package com.example.demo.slack.bot;

import com.example.demo.common.dto.request.RequestBotMessage;
import com.example.demo.slack.bot.exception.SlackPostMessageFailException;
import com.example.demo.slack.bot.exception.SlackResponseException;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

/**
 * 슬랙 클라이언트
 */
@Slf4j
public class SlackClient implements InitializingBean, DisposableBean {

    private final Slack slack;

    private final MethodsClient methodsClient;

    public SlackClient(String token) {

        this.slack = Slack.getInstance();
        this.methodsClient = this.slack.methods(token);

        log.info("[Slack] Connect Slack Bot. token: {}", token);
    }

    public void sendMessage(RequestBotMessage requestBotMessage) {

        try {

            ChatPostMessageResponse response = this.methodsClient.chatPostMessage(chatPostMessageRequestBuilder -> chatPostMessageRequestBuilder
                    .channel(requestBotMessage.getRoom())
                    .text(requestBotMessage.getMessage()));

            if ( !response.isOk() ) {

                throw new SlackResponseException(response.getError());
            }
        } catch ( SlackApiException | IOException e ) {

            throw new SlackPostMessageFailException(e);
        } catch ( SlackResponseException e ) {

            throw e;
        }
    }

    @Override
    public void destroy() throws Exception {

        this.slack.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
