package com.lq.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tianmeng
 * @date 2020/11/5
 */
@Slf4j
@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    private RestTemplate restTemplate;

    @Autowired
    public OrderConsulController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/order/consumer/consul")
    public String order() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
