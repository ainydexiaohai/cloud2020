package com.liuhangs.springcloud.order.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**服务消费者controller
 * @author 11757
 * @DATE 2020/7/14
 */
@RequestMapping("consumer/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("query/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id)
    {
        CommonResult commonResult = orderService.queryPaymentById(id);
        return commonResult;
    }

    @GetMapping("timeout/{id}")
    public CommonResult testTimeout(@PathVariable("id") Long id)
    {
        CommonResult commonResult = orderService.testTimeout(id);
        return commonResult;
    }

}
