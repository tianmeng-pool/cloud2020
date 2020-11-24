package com.lq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9004.class, args);
    }
}
