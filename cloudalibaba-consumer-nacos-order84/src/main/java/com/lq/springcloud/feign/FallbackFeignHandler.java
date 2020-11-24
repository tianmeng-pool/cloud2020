package com.lq.springcloud.feign;

import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@Component
public class FallbackFeignHandler implements PaymentFeignService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级处理方法  FallbackFeignHandler...paymentSQL");
    }
}
