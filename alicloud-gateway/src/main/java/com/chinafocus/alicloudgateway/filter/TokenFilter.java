package com.chinafocus.alicloudgateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("测试全局过滤："+exchange.getRequest().getId());
        /*if (exchange.getRequest().getId() != null){
            throw new RuntimeException("异常拦截");
        }*/
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
