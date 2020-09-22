package com.chinafocus.alicloudrocket;

import com.chinafocus.alicloudrocket.service.ContentBindings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({ContentBindings.class})
@SpringBootApplication
public class AlicloudRocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlicloudRocketApplication.class, args);
    }

}
