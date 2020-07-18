package com.liuhangs.springcloud.payment.service;

import com.liuhangs.springcloud.api.entities.Payment;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
public interface PaymentService {

    public int save(Payment payment);

    public Payment queryPaymentById(Long id);

}
