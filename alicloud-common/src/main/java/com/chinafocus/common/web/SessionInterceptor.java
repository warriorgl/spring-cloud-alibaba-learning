package com.chinafocus.common.web;

import com.chinafocus.common.constants.WebConstants;
import com.chinafocus.common.enums.ErrorCode;
import com.chinafocus.common.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(WebConstants.SESSION_USER) == null){
            throw new ServiceException(ErrorCode.NOT_LOGIN);
        }
        return super.preHandle(request, response, handler);
    }




}
