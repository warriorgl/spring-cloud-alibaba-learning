package com.chinafocus.alicloudnacosdiscoveryconsumer.service;


import com.alicloud.api.object.TestObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-provider")
public interface FeignService {

    @GetMapping("/provider/test")
    TestObject getTestObject();

}
