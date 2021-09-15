package com.example.demo.common.exception;

/**
 * 공통 익셉션 클래스
 *
 * @author Demo
 * @since 2021-09-14
 * @see {@link RuntimeException}
 */
public class CommonException extends RuntimeException {

    private String errorMsg = "";

    public CommonException(Throwable cause, String errorMsg) {
        super(errorMsg, cause);

        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
