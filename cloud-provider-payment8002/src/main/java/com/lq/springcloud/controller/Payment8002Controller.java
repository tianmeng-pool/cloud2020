package com.lq.springcloud.controller;

import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import com.lq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author tianmeng
 * @date 2020/11/2
 */
@Slf4j
@RestController
public class Payment8002Controller {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public Payment8002Controller(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据结果: {}", result);
        if (result > 0)
            return new CommonResult<>(200, "插入数据成功,serverPort: " + serverPort, result);
        else
            return new CommonResult<>(500, "插入数据失败");
    }

    @GetMapping("/payment/query/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功，结果为: {}", payment);
        return new CommonResult<>(200, "查询成功,serverPort: " + serverPort, payment);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
