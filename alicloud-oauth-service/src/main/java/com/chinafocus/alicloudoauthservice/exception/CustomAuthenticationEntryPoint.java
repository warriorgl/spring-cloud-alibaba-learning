package com.chinafocus.alicloudoauthservice.exception;

import com.chinafocus.common.enums.ErrorCode;
import com.chinafocus.common.exception.AuthExpception;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证异常
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e){

        Throwable cause = e.getCause();
        if (cause != null){
            throw new AuthExpception(ErrorCode.REQUEST_TOKEN_FAILED);
        }
    }
}
