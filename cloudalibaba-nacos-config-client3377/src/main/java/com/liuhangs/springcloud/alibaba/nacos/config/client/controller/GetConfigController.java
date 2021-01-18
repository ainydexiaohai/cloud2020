package com.liuhangs.springcloud.alibaba.nacos.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alibaba/nacos/config/client")
@RestController
@RefreshScope  //在nacos中修改配置后，让此controller能及时刷新配置信息
public class GetConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get")
    public String getConfig()
    {
        return "用户调用" + serverPort + "服务器成功，获得配置信息：" + configInfo;
    }
}
