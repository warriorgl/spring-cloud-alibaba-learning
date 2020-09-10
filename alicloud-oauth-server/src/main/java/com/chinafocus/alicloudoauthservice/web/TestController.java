package com.chinafocus.alicloudoauthservice.web;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chinafocus.alicloudoauthservice.mapper.UserMapper;
import com.chinafocus.alicloudoauthservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class TestController {


    @Autowired
    public UserMapper userMapper;

    @GetMapping("/getByName")
    public User getByName(String username){
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    @GetMapping("/current")
    public Principal user(Principal principal){
        return principal;
    }


}
