package com.example.demo.slack.bot.exception;

import com.example.demo.common.exception.CommonException;

/**
 * 슬랫 API IO 오류
 *
 * @see {@link CommonException}
 */
public class SlackAdapterException extends CommonException {

    public SlackAdapterException(Throwable e, String errorMsg) {

        super(e, errorMsg);
    }
}
