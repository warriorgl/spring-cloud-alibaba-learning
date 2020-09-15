package com.chinafocus.common.exception;


import com.chinafocus.common.enums.ErrorCode;

public class OAuthException extends RuntimeException {

    private ErrorCode errorCode;

    public OAuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
