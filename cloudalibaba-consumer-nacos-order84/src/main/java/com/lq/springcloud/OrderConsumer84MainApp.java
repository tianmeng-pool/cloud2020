package com.lq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsumer84MainApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer84MainApp.class, args);
    }
}
