package com.chinafocus.alicloudnacosdiscoveryconsumer.web;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.chinafocus.alicloudnacosdiscoveryconsumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class DefaultController {


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
    public String feignTest(){
        return JSON.toJSONString(feignService.getTestObject());
    }


    @GetMapping("/sentinel")
    @SentinelResource("hello")
    public String sentinel(){
        return "hello";
    }



}
