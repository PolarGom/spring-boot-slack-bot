package com.example.demo.common.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * 결과 클래스
 *
 * @author Demo
 * @since 2021-09-16
 */
@Builder
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult {

    @NonNull
    @Builder.Default
    private boolean success = true;

    @NonNull
    @Builder.Default
    private String errMsg = "";

    private ResponseBody body;

}
