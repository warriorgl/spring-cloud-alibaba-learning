package com.chinafocus.alicloudnacosdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.chinafocus.alicloudnacosdiscovery","com.chinafocus.common"})
public class AlicloudNacosDiscoveryApplication {

    public static void main(String[] args){
        SpringApplication.run(AlicloudNacosDiscoveryApplication.class, args);
    }

}
