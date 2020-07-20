package com.liuhangs.springcloud.order.service;

import com.liuhangs.springcloud.api.entities.CommonResult;
import com.liuhangs.springcloud.api.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/** OpenFeign调用CLOUD-PROVIDER-PAYMENT服务
 * @author 11757
 * @DATE 2020/7/14
 */
@FeignClient(name="CLOUD-PROVIDER-PAYMENT")
@Service
public interface OrderService {

    @GetMapping("provider/payment/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id);

    /**
     * 故意暂停3秒
     * @param id
     * @return
     */
    @GetMapping("provider/payment/timeout/{id}")
    public CommonResult testTimeout(@PathVariable("id") Long id);
}
