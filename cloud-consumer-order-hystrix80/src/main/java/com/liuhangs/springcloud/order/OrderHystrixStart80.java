package com.liuhangs.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 11757
 * @DATE 2020/7/16
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixStart80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderHystrixStart80.class, args);
    }
}
