package com.lq.springcloud.controller;

import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import com.lq.springcloud.feign.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author tianmeng
 * @date 2020/11/6
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService feignService;

    @GetMapping("/consumer/payment/query/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 客户端一般默认等待3秒钟
        return feignService.paymentFeignTimeout();
    }
}
