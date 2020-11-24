package com.lq.springcloud.controller;

import com.lq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/7
 */
@Slf4j
@RestController
public class PaymentHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String reslut = paymentService.paymentInfo_OK(id);
        log.info("result: " + reslut);
        return reslut;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String reslut = paymentService.paymentInfo_TimeOut(id);
        log.info("result: " + reslut);
        return reslut;
    }

    // 服务熔断
    @GetMapping("/paymemt/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("result: " + result);
        return result;
    }
}
