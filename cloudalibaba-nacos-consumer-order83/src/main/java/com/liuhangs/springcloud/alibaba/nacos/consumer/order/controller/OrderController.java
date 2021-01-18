package com.liuhangs.springcloud.alibaba.nacos.consumer.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/nacos/consumer/order")
@RestController
public class OrderController {

    @Value("${server.port}")
    private String serverPost;

    //在NacosOrderConfig类中加了@LoadBalanced注解，可以使用负载均衡
    //nacos是集成了ribbon，所以可以使用http调用和负载均衡
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public String getOrderInfoById(@PathVariable("id") String id) {
        return restTemplate.getForObject("http://cloudalibaba-provider-payment/alibaba/provider/payment/" + id, String.class);
    }


}
