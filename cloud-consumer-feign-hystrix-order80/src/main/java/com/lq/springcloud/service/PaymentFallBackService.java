package com.lq.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author tianmeng
 * @date 2020/11/7
 */
@Component
public class PaymentFallBackService implements PaymentFeignService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallBackService fall back paymentInfo_TimeOut";
    }
}
