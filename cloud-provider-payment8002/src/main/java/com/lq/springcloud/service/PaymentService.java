package com.lq.springcloud.service;

import com.lq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tianmeng
 * @date 2020/11/2
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
