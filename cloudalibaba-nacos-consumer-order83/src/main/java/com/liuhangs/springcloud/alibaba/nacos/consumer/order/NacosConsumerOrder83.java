package com.liuhangs.springcloud.alibaba.nacos.consumer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumerOrder83 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrder83.class);
    }
}
