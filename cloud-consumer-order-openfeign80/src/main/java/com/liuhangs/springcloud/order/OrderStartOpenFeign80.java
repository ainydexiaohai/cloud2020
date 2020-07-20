package com.liuhangs.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**服务消费者启动类
 * @author 11757
 * @DATE 2020/7/14
 */
@SpringBootApplication
@EnableFeignClients  //开始OpenFeign
public class OrderStartOpenFeign80 {

    public static void main(String[] args)
    {
        SpringApplication.run(OrderStartOpenFeign80.class, args);
    }
}
