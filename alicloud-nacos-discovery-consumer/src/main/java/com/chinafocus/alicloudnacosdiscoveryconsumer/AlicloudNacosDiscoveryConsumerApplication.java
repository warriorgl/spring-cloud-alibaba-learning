package com.chinafocus.alicloudnacosdiscoveryconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.alicloud.api")
@ComponentScan(basePackages = {"com.chinafocus.alicloudnacosdiscoveryconsumer","com.chinafocus.common"})
@SpringBootApplication
public class AlicloudNacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlicloudNacosDiscoveryConsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
