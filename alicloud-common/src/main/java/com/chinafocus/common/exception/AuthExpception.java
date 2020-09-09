package com.chinafocus.common.exception;


import com.chinafocus.common.enums.ErrorCode;

public class AuthExpception extends RuntimeException{


    private ErrorCode errorCode;

    public AuthExpception(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
