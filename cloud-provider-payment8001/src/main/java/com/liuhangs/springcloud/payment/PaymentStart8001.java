package com.liuhangs.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**服务提供者启动类
 * @author 11757
 * @DATE 2020/7/10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现注解
public class PaymentStart8001 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentStart8001.class, args);
    }
}
