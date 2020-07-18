package com.liuhangs.springcloud.payment.mapper;

import com.liuhangs.springcloud.api.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
@Mapper
public interface PaymentMapper {

    public int save(Payment payment);

    public Payment queryPaymentById(Long id);

}
