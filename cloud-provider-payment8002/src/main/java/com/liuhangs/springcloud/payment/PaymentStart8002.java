package com.liuhangs.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentStart8002 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentStart8002.class, args);
    }
}
