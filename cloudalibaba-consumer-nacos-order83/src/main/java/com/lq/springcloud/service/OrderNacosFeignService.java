package com.lq.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tianmeng
 * @date 2020/11/14
 */
@FeignClient(name = "cloud-payment-provider")
public interface OrderNacosFeignService {

    @GetMapping("/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
