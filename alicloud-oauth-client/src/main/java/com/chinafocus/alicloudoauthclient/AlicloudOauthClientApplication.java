package com.chinafocus.alicloudoauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AlicloudOauthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlicloudOauthClientApplication.class, args);
    }

}
