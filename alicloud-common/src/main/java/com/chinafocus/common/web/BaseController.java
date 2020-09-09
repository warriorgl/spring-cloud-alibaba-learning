package com.chinafocus.common.web;


import com.chinafocus.common.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;



    protected ResultBody success(Object data) {
        return new ResultBody(data);
    }

    protected ResultBody success() {
        return new ResultBody("");
    }

    protected ResultBody failure(Integer code, String message) {
        ResultBody resultBody = new ResultBody();
        resultBody.setMessage(message);
        resultBody.setCode(code);

        return resultBody;
    }

}
