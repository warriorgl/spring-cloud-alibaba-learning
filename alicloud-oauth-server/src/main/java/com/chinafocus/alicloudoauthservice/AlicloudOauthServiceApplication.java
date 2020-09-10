package com.chinafocus.alicloudoauthservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@MapperScan(basePackages = {"com.chinafocus.alicloudoauthservice.mapper"})
public class AlicloudOauthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlicloudOauthServiceApplication.class, args);
    }



}
