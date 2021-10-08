package com.example.demo.slack.bot.exception;

import com.example.demo.common.exception.CommonException;

/**
 * 슬랫 API 오류
 *
 * @see {@link CommonException}
 */
public class SlackPostMessageFailException extends CommonException {

    public SlackPostMessageFailException(Throwable e) {

        super(e, "슬랙 메시지 전송 중 오류가 발생하였습니다.");
    }
}
