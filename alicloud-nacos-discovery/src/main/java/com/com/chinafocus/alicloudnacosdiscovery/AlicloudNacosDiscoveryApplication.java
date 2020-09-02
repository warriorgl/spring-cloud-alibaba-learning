package com.com.chinafocus.alicloudnacosdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlicloudNacosDiscoveryApplication {

    public static void main(String[] args){
        SpringApplication.run(AlicloudNacosDiscoveryApplication.class, args);
    }

}
