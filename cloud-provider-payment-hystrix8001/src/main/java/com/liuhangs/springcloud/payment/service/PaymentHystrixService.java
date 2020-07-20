package com.liuhangs.springcloud.payment.service;

import com.liuhangs.springcloud.api.entities.CommonResult;

/**payment服务接口
 * @author 11757
 * @DATE 2020/7/15
 */
public interface PaymentHystrixService {

    /**
     * 正常方法
     * @param id
     * @return
     */
    public CommonResult getPaymentOK(Long id);

    /**
     * 超时方法
     * @param id
     * @return
     */
    public CommonResult getPaymentTimeOut(Long id);

    /**
     * 熔断方法
     * @param id
     * @return
     */
    public CommonResult getPaymentBreak(Long id);

    /**
     * 给80服务消费者准备的超时方法，避免和前面的服务降级方法混淆
     * @param id
     * @return
     */
    public CommonResult getPaymentTimeOutFor80(Long id);
}
