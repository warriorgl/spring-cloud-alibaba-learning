package com.alicloud.api.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;


/**
 * 通用feign配置类
 */
@Component
public class FeignConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default();
    }

    @Bean
    public Request.Options options(){
        return new Request.Options(60l, TimeUnit.SECONDS,60l,TimeUnit.SECONDS,true);
    }



    @Bean
    public Decoder feignDecoder(){
        return new AwardResponseEntityDecoder(new SpringDecoder(this.messageConverters));
    }


}
