package com.liuhangs.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**consul启动：cmd中切换到D:\tools\consul目录下，执行consul agent -dev
 * @author 11757
 * @DATE 2020/7/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentStartConsul8006 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentStartConsul8006.class, args);
    }
}
