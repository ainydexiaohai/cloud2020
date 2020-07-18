package com.liuhangs.springcloud.payment.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import com.liuhangs.springcloud.payment.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 11757
 * @DATE 2020/7/15
 */
    @RequestMapping("provider/payment/hystrix")
@RestController
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public CommonResult getPaymentOK(@PathVariable("id") Long id)
    {
        return paymentHystrixService.getPaymentOK(id);
    }

    @GetMapping("/timeout/{id}")
    public CommonResult getPaymentTimeOut(@PathVariable("id") Long id)
    {
        return paymentHystrixService.getPaymentTimeOut(id);
    }

    /**
     * 熔断测试
     * @param id
     * @return
     */
    @GetMapping("/break/{id}")
    public CommonResult getPaymentBreak(@PathVariable("id") Long id) {
        return paymentHystrixService.getPaymentBreak(id);
    }
}
