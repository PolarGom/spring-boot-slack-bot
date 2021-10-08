package com.example.demo.common.dto.request;

import lombok.*;

/**
 * 봇 메세지 요청
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestBotMessage {
    
    private String message;
    
    private String user;
    
    private String room;
}
