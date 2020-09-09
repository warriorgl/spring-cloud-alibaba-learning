package com.alicloud.api.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 微服务之间feign调用请求头丢失的问题
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        if (httpServletRequest != null){
            Map<String, String> headers = getHeaders(httpServletRequest);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestTemplate.header(entry.getKey(), entry.getValue());
            }
        }
    }


    private HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        if(enumeration!=null){
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                String value = request.getHeader(key);
                map.put(key, value);
            }
        }
        return map;
    }
}
