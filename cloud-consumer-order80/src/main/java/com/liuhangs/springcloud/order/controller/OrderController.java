package com.liuhangs.springcloud.order.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**客户端接口
 * @author 11757
 * @DATE 2020/7/11
 */
@RequestMapping("consumer/order")
@RestController
public class OrderController {

    //private String PAYMENT_URL = "HTTP://localhost:8001";
    //使用Ribbon，用服务名称调用服务提供者
    private String PAYMENT_URL = "HTTP://CLOUD-PROVIDER-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("create")
    public CommonResult save(Payment payment)
    {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/provider/payment",
                payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping("query/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id)
    {
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/provider/payment/"
                + id, CommonResult.class);
        return commonResult;
    }
}
