package com.liuhangs.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**Config配置中心服务器
 * @author 11757
 * @DATE 2020/7/21
 */
@SpringBootApplication
@EnableConfigServer  //开启配置中心服务
@EnableEurekaClient  //开启Eureka客户端配置
public class ConfigStart3344 {

    public static void main(String[] args)
    {
        SpringApplication.run(ConfigStart3344.class, args);
    }
}
