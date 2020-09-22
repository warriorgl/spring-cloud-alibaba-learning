package com.chinafocus.alicloudrocket.service;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface ContentBindings {

    @Output("output1")
    MessageChannel testOutput();

    @Output("output2")
    SubscribableChannel testOutput2();
}
