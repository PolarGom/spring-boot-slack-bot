package com.example.demo.common.dto.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 단일 결과 바디 클래스
 *
 * @author EDA
 * @since 2019-02-18
 * @see {@link ResponseOneBody}
 */
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class ResponseOneBody<K, V> implements ResponseBody {

    @Builder.Default
    private Map<K, V> info = new HashMap<>();
}
