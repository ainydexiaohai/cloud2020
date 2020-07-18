package com.liuhangs.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 11757
 * @DATE 2020/7/11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderStartZK80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderStartZK80.class, args);
    }
}
