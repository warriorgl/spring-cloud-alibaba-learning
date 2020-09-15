package com.alicloud.api.config;


import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignException implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        System.out.println("访问结果码："+response.status());
        return null;
    }
}
