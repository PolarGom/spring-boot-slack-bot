package com.example.demo.bot.dto.response;

import lombok.*;

/**
 * 슬랙 이벤트 검증 응답
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseUrlVerify {

    private String challenge;
}
