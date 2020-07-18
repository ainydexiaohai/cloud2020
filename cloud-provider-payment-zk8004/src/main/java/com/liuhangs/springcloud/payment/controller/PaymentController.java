package com.liuhangs.springcloud.payment.controller;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("zk")
    public CommonResult queryZKService()
    {
        return new CommonResult(200, "调用端口" + SERVER_PORT + "查询ZK服务成功" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
