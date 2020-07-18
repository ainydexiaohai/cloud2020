package com.liuhangs.springcloud.payment.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 11757
 * @DATE 2020/7/12
 */
@RequestMapping("provider/payment")
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @GetMapping("consul")
    public CommonResult queryConsulService()
    {
        return new CommonResult(200, "调用端口" + SERVER_PORT + "查询Consul服务成功" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
