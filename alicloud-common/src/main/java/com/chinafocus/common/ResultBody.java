package com.chinafocus.common;

import java.io.Serializable;

public class ResultBody implements Serializable {

    /**
     * 请求数据是否成功
     * true  是
     * false 否
     */
    public boolean success;

    /**
     * 返回码
     */
    public int code;

    /**
     * 信息说明
     */
    public String message;


    /**
     * 返回数据
     */
    public Object data;


    /**
     * 时间戳
     */
    public Long timestamp = System.currentTimeMillis();


    public ResultBody() {
        this.success = true;
        this.setCode(200);
    }

    public ResultBody(Object data) {
        this.setSuccess(true);
        this.data = data;
        this.setMessage("");
        this.setCode(200);
    }

    public ResultBody(int code, String message) {
        this.setSuccess(false);
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
