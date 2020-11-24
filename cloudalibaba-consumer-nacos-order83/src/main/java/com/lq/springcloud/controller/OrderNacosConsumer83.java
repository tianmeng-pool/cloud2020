package com.lq.springcloud.controller;

import com.lq.springcloud.service.OrderNacosFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tianmeng
 * @date 2020/11/14
 */
@Slf4j
@RestController
public class OrderNacosConsumer83 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderNacosFeignService feignService;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        System.out.println(serverURL);
        return feignService.getPayment(id);
    }
}
