package com.liuhangs.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**网关工程启动类
 * @author 11757
 * @DATE 2020/7/20
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayStart9527 {

    public static void main(String[] args)
    {
        SpringApplication.run(GatewayStart9527.class, args);
    }
}
