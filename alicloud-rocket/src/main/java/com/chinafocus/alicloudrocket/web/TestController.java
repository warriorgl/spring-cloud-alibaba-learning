package com.chinafocus.alicloudrocket.web;

import com.chinafocus.alicloudrocket.service.ContentBindings;
import com.chinafocus.alicloudrocket.service.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class TestController {

    @Autowired
    private ContentBindings contentBindings;

    /**
     * 发送字符串
     * 发送对象
     */
    @GetMapping("/send")
    public void sendMsg(){
        Message message = MessageBuilder.withPayload("发送测试").build();
        contentBindings.testOutput().send(message);
        Message message2 = MessageBuilder
                .withPayload(new Foo().setId(1).setName("测试"))
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build();
        contentBindings.testOutput2().send(message2);
    }


    @StreamListener("output1")
    public void receiveMsg(String msg){
        log.info("接收到的数据："+msg);
    }

    @StreamListener("output2")
    public void receiveMsg(@Payload Foo foo){
        log.info("对象数据："+foo.getName());
    }



}
