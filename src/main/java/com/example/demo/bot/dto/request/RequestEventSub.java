package com.example.demo.bot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 슬랙 이벤트 구독 정보
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestEventSub {

    private String token;

    private String challenge;

    private String type;

    @JsonProperty("team_id")
    private String teamId;

    @JsonProperty("api_app_id")
    private String apiAppId;

    @JsonProperty("is_ext_shared_channel")
    private boolean isExtSharedChannel;

    @JsonProperty("event_context")
    private String eventContext;

    private RequestEvent event;
}
