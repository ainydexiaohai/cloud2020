package com.liuhangs.springcloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 11757
 * @DATE 2020/7/11
 */
@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced //LoadBalanced注解表示使用RestTemplate负载均衡调用功能
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
