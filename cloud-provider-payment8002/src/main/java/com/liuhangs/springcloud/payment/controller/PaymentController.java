package com.liuhangs.springcloud.payment.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import com.liuhangs.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
@RequestMapping("provider/payment")
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public CommonResult save(@RequestBody Payment payment)
    {
        int result = paymentService.save(payment);
        if(result == 1) {
            return new CommonResult(200, "调用端口" + SERVER_PORT + "保存支付流水成功");
        }
        return new CommonResult(444, "调用端口" + SERVER_PORT + "保存支付流水失败");
    }

    @GetMapping("{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.queryPaymentById(id);
        if(payment != null) {
            return new CommonResult<Payment>(200, "调用端口" + SERVER_PORT + "查询支付流水成功", payment);
        }
        return new CommonResult<Payment>(444, "调用端口" + SERVER_PORT + "查询支付流水失败");
    }
}
