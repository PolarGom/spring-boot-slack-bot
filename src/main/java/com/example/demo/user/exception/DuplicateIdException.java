package com.example.demo.user.exception;

import com.example.demo.common.exception.CommonException;

public class DuplicateIdException extends CommonException {

    private final String errorMsg = "동일한 사용자 아이디가 존재합니다.";

    public DuplicateIdException() {
        super("동일한 사용자 아이디가 존재 합니다.");
    }
}
