package com.liuhangs.springcloud.order.service;

import com.liuhangs.springcloud.api.entities.CommonResult;
import org.springframework.stereotype.Service;

/**PaymentHystrixService类对应的服务降级处理类
 * @author 11757
 * @DATE 2020/7/16
 */
@Service
public class PaymentHystrixFallBackService implements PaymentHystrixService {

    @Override
    public CommonResult getPaymentOK(Long id)
    {
        return new CommonResult(200, "使用id:" + id
                +"调用PaymentHystrixService服务的getPaymentOK方法失败，进入降级处理类");
    }

    @Override
    public CommonResult getPaymentTimeOut(Long id)
    {
        return new CommonResult(200, "使用id:" + id
                +"调用PaymentHystrixService服务的getPaymentTimeOut方法失败，进入降级处理类");
    }
}
