package com.liuhangs.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**提供给浏览器测试的接口
 * @author 11757
 * @DATE 2020/7/21
 */
@RequestMapping("/config/client")
@RestController
@RefreshScope  //打开动态刷新功能
public class ConfigClientController {

    @Value("${config.prod.version}")
    private String version;

    @GetMapping("version")
    public String getVersion() {
        return "生产环境版本为：" + version;
    }
}
