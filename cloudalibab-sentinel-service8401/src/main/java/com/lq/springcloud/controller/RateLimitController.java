package com.lq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import com.lq.springcloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@Slf4j
@RestController
public class RateLimitController {

    @SentinelResource(value = "byResouce", blockHandler = "handlerException")
    @GetMapping("/byResouce")
    public CommonResult<Payment> byResouce() {
        return new CommonResult<>(200, "按资源名限流ok", new Payment(2020L, "serial001"));
    }

    public CommonResult handlerException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t 服务资源不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按客户自定义", new Payment(2020L, "serial003"));
    }
}
