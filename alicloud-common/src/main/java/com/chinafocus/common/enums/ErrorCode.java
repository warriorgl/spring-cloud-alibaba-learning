package com.chinafocus.common.enums;


public enum ErrorCode {

    REQUEST_NOT_FOUND(404, "资源不存在"),
    REQUEST_TOKEN_FAILED(401, "Token无效"),
    REQUEST_ACCESS_DENIED(403, "无权限访问"),
    SERVER_ERROR(500, "系统错误"),
    PARAMETER_ERROR(3000, "参数验证失败"),
    SERVICE_ERROR(2000, "业务逻辑错误"),
    NOT_LOGIN(1000,"未登录"),
    LOGIN_ERROR(1001,"用户名或密码错误");
    public int code;

    public String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
