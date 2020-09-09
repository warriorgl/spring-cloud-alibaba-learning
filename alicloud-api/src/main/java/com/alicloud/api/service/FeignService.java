package com.alicloud.api.service;


import com.alicloud.api.ServiceConstants;
import com.alicloud.api.config.FeignConfig;
import com.alicloud.api.dto.TestObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name = ServiceConstants.FEIGN_SERVICE,configuration = FeignConfig.class)
public interface FeignService {

    @GetMapping(value = ServiceConstants.FEIGN_SERVICE_API_TEST)
    TestObject getTestObject();

}
