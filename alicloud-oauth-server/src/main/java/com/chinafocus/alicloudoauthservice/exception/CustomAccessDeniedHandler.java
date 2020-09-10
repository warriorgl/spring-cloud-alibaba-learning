package com.chinafocus.alicloudoauthservice.exception;

import com.chinafocus.common.enums.ErrorCode;
import com.chinafocus.common.exception.AuthExpception;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限异常
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        Throwable cause = e.getCause();
        if (cause != null){
            throw new AuthExpception(ErrorCode.REQUEST_ACCESS_DENIED);
        }
    }
}
