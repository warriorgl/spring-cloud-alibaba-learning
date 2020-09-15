package com.chinafocus.alicloudnacosdiscoveryconsumer.feign;


import com.alicloud.api.ServiceConstants;
import com.alicloud.api.config.FeignConfig;
import com.alicloud.api.dto.TestObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(name = ServiceConstants.FEIGN_SERVICE,fallback = FeignServiceFallback.class,configuration = FeignConfig.class)
public interface FeignService {

    @GetMapping(value = ServiceConstants.FEIGN_SERVICE_API_TEST)
    TestObject getTestObject();

}
