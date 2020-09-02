package com.com.chinafocus.alicloudnacosdiscovery.web;


import com.alicloud.api.object.TestObject;
import com.com.chinafocus.alicloudnacosdiscovery.property.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 如果想实现自动刷新需要配置注解@RefreshScope
     */
    @Value("${alicloud.env}")
    private String alicloud;

    @Autowired
    private ConfigProperty configProperty;

    @GetMapping("/provider/test")
    public TestObject provider(){
        return new TestObject().setDesc("1").setId(1l).setName("hello boy!");
    }

    @RequestMapping("/provider/config")
    public String getConfigValue(){
        return configProperty.getEnv();
    }

}
