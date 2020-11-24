package com.lq.springcloud.cotroller;

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
 * @date 2020/11/16
 */
@Slf4j
@RestController
public class CircleBreakerFeignController {

    @Autowired
    private PaymentFeignService feignService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return feignService.paymentSQL(id);
    }
}
