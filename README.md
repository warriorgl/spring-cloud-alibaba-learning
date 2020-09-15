# spring-cloud-alibaba-dev-model
-- QQ交流群：199016700--
### 简介
该项目为个人学习项目，了解spring cloud alibaba框架和各个组件的使用，加入其它组件构建一个可直接开发脚手架模型。各子项目详细介绍会写到对应readme.md中
### 项目依赖版本说明
     Java版本：1.8
     spring cloud alibaba：2.2.1.RELEASE
     spring-cloud-build：2.2.3.RELEASE
     其它spring-cloud组件:2.2.2.RELEASE
### 目前功能
    1.服务注册与发现
    2.feign负载均衡
    3.配置中心动态获取配置
    4.gateway路由
    5.sentinel监控、熔断
    6.oauth2服务端和客户端
    7.基于header中token的用户认证机制（alicloud-nacos-discovery）
    8.redis多数据源配置（alicloud-nacos-discovery）
    9.feign异常处理（alicloud-nacos-discovery-consumer）
##### Nasoc地址：https://nacos.io/zh-cn/index.html
    当前使用版本：nacos-server-1.3.2.zip
    配置文件：nacos.properties替换zip包中application文件。数据库请提前创建好。
##### Sentinel地址：https://github.com/alibaba/Sentinel/releases
    当前使用版本：1.8.0
