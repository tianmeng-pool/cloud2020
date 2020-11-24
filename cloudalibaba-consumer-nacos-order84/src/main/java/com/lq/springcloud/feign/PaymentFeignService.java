package com.lq.springcloud.feign;

import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@FeignClient(value = "cloud-payment-provider", fallback = FallbackFeignHandler.class)
public interface PaymentFeignService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
