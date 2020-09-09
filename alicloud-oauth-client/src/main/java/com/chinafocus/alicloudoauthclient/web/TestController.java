package com.chinafocus.alicloudoauthclient.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {




    @GetMapping("/client/getUser")
    public String test(){
        return "success";
    }
}
