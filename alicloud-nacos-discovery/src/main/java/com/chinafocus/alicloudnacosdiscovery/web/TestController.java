package com.chinafocus.alicloudnacosdiscovery.web;


import com.alicloud.api.dto.TestObject;
import com.chinafocus.alicloudnacosdiscovery.property.ConfigProperty;
import com.chinafocus.common.ResultBody;
import com.chinafocus.common.enums.ErrorCode;
import com.chinafocus.common.exception.ServiceException;
import com.chinafocus.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController extends BaseController {

    /**
     * 如果想实现自动刷新需要配置注解@RefreshScope
     */
    @Value("${alicloud.env}")
    private String alicloud;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ConfigProperty configProperty;

    @GetMapping("/provider/test")
    public TestObject provider(HttpServletRequest request){
        //throw new ServiceException("业务异常",ErrorCode.SERVICE_ERROR);

        return new TestObject().setDesc("1").setId(1l).setName("hello boy!");
    }

    @RequestMapping("/provider/config")
    public ResultBody getConfigValue(){
        redisTemplate.opsForValue().set("springredis","test3");
        return success(configProperty.getEnv());
    }

}
