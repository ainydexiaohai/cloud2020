package com.liuhangs.springcloud.order.service;

import com.liuhangs.springcloud.api.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**fallback属性为统一的服务降级处理类
 * @author 11757
 * @DATE 2020/7/16
 */
@FeignClient(name="CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentHystrixFallBackService.class)
@Service
public interface PaymentHystrixService {

    @GetMapping("provider/payment/hystrix/ok/{id}")
    public CommonResult getPaymentOK(@PathVariable("id") Long id);

    /**
     * 调用服务提供者的getPaymentTimeOutFor80接口
     * @param id
     * @return
     */
    @GetMapping("provider/payment/hystrix/timeoutfor80/{id}")
    public CommonResult getPaymentTimeOutFor80(@PathVariable("id") Long id);
}
