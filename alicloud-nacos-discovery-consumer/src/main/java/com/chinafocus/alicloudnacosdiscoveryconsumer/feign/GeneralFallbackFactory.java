package com.chinafocus.alicloudnacosdiscoveryconsumer.feign;

import com.chinafocus.common.enums.ErrorCode;
import com.chinafocus.common.exception.ServiceException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * FeignClient 设置fallbackFactory 返回统一格式异常  与fallback不能共用
 */
@Component
public class GeneralFallbackFactory implements FallbackFactory {


    @Override
    public Object create(Throwable throwable) {
        throw new ServiceException(throwable.getMessage(), ErrorCode.SERVICE_ERROR);
    }
}
