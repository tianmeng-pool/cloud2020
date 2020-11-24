package com.lq.springcloud.controller;

import com.lq.springcloud.entity.CommonResult;
import com.lq.springcloud.entity.Order;
import com.lq.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "订单创建成功");
    }
}
