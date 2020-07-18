package com.liuhangs.springcloud.payment.service;

import com.liuhangs.springcloud.api.entities.CommonResult;

/**
 * @author 11757
 * @DATE 2020/7/15
 */
public interface PaymentHystrixService {

    public CommonResult getPaymentOK(Long id);

    public CommonResult getPaymentTimeOut(Long id);

    public CommonResult getPaymentBreak(Long id);
}
