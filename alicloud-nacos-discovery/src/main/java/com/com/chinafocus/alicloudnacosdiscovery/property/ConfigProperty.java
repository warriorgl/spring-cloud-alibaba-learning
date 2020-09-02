package com.com.chinafocus.alicloudnacosdiscovery.property;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alicloud")
@RefreshScope
public class ConfigProperty {

    private String env;
}
