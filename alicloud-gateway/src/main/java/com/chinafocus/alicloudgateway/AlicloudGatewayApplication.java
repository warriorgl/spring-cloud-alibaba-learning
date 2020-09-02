package com.chinafocus.alicloudgateway;

import com.chinafocus.alicloudgateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AlicloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlicloudGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter customFilter(){
        return new TokenFilter();
    }
}
