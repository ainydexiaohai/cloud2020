package com.liuhangs.springcloud.order.service;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 11757
 * @DATE 2020/7/14
 */
@FeignClient(name="CLOUD-PROVIDER-PAYMENT")
@Service
public interface OrderService {

    @GetMapping("provider/payment/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id);
}
