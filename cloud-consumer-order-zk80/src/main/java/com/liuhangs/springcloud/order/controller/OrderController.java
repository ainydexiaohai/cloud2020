package com.liuhangs.springcloud.order.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 11757
 * @DATE 2020/7/12
 */
@RequestMapping("consumer/order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private String PAYMENT_URL_ZK = "http://cloud-provider-payment";


    @GetMapping("zk")
    public CommonResult queryZKService()
    {
        return restTemplate.getForObject(PAYMENT_URL_ZK + "/provider/payment/zk", CommonResult.class);
    }
}
