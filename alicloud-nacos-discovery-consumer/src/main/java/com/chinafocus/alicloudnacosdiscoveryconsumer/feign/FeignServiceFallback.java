package com.chinafocus.alicloudnacosdiscoveryconsumer.feign;

import com.alicloud.api.dto.TestObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * /**
 *  * FeignClient 设置fallback 返回远程服务错误时返回对象  与fallbackFactory不能共用
 *
 *  */
@Slf4j
@Component
public class FeignServiceFallback implements FeignService {


    @Override
    public TestObject getTestObject() {
        log.error("服务调用接口异常");
        return null;
    }
}
