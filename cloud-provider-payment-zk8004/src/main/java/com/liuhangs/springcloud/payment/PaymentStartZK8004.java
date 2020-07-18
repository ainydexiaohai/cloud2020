package com.liuhangs.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 11757
 * @DATE 2020/7/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentStartZK8004 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentStartZK8004.class, args);
    }
}
