package com.liuhangs.springcloud.alibaba.provider.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alibaba/provider/payment")
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("{id}")
    public String queryPaymentById(@PathVariable("id") Long id)
    {
        return "用户使用参数" + id + "调用" + serverPort + "服务器成功";
    }
}
