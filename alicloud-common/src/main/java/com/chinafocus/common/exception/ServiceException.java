package com.chinafocus.common.exception;

import com.chinafocus.common.enums.ErrorCode;

public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;


    public ServiceException(ErrorCode error) {
        super(error.message);
        this.errorCode = error;
    }

    public ServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
