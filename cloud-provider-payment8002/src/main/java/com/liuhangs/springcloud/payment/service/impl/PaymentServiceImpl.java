package com.liuhangs.springcloud.payment.service.impl;

import com.liuhangs.springcloud.api.entities.Payment;
import com.liuhangs.springcloud.payment.mapper.PaymentMapper;
import com.liuhangs.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment)
    {
        return paymentMapper.save(payment);
    }

    @Override
    public Payment queryPaymentById(Long id)
    {
        return paymentMapper.queryPaymentById(id);
    }
}
