package com.example.demo.bot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 슬랙 이벤트 정보
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestEvent {

    @JsonProperty("client_msg_id")
    private String clientMsgId;

    private String type;

    private String text;

    private String user;

    private String ts;

    private String team;

    private String channel;

    @JsonProperty("eventTs")
    private String event_ts;

    @JsonProperty("channel_type")
    private String channelType;
}
