package com.example.demo.common.dto.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 결과 목록 바디 클래스
 *
 * @author Demo
 * @since 2021-09-16
 * @see {@link ResponseBody}
 */
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class ResponseListBody<T> implements ResponseBody {

    @Builder.Default
    private int totalCount = 0;

    @Builder.Default
    private int totalPage = 0;

    @Builder.Default
    private List<T> list = new ArrayList<>();
}
