package com.example.demo.bot.dto.request;

import lombok.*;

/**
 * 슬랙 이벤트 검증 요청
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestUrlVerify {

    private String token;

    private String challenge;

    private String type;
}
