package com.liuhangs.springcloud.order;

import com.liuhangs.springcloud.rule.LbConfig;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 11757
 * @DATE 2020/7/11
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PROVIDER-PAYMENT", configuration=LbConfig.class)
public class OrderStart80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderStart80.class, args);
    }
}
