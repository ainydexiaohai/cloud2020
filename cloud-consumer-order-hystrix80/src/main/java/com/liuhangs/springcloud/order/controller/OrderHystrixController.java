package com.liuhangs.springcloud.order.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.order.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11757
 * @DATE 2020/7/16
 */
@RequestMapping("/consumer/order/hystrix")
@RestController
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public CommonResult getPaymentOK(@PathVariable("id") Long id) {
        return paymentHystrixService.getPaymentOK(id);
    }

    @GetMapping("/timeout/{id}")
    public CommonResult getPaymentTimeOut(@PathVariable("id") Long id) {
        return paymentHystrixService.getPaymentTimeOut(id);
    }
}
