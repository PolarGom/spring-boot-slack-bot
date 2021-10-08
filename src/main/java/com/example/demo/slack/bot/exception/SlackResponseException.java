package com.example.demo.slack.bot.exception;

import com.example.demo.common.exception.CommonException;

/**
 * 슬랫 API 오류
 *
 * @see {@link CommonException}
 */
public class SlackResponseException extends CommonException {

    public SlackResponseException(String errorMsg) {

        super(errorMsg);
    }
}
