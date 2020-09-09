package com.chinafocus.alicloudnacosdiscoveryconsumer.web;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alicloud.api.dto.TestObject;
import com.alicloud.api.service.FeignService;
import com.chinafocus.common.ResultBody;
import com.chinafocus.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/consumer")
public class DefaultController extends BaseController {


    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignService feignService;


    /**
     * 默认http调用
     * @return
     */
    @GetMapping("/defalut")
    public String defaultTest(){
        return restTemplate.getForObject("http://service-provider/provider/test",String.class);
    }

    @GetMapping("/feign")
    public ResultBody feignTest(HttpServletRequest request){
        TestObject testObject=feignService.getTestObject();
        return success(testObject);
    }


    @GetMapping("/sentinel")
    @SentinelResource("hello")
    public ResultBody sentinel(){
        return success("hello");
    }



}
