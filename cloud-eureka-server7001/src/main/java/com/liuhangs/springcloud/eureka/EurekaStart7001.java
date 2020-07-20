package com.liuhangs.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**注册中心启动类
 * @author 11757
 * @DATE 2020/7/11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaStart7001 {

    public static void main(String[] args)
    {
        SpringApplication.run(EurekaStart7001.class, args);
    }
}
