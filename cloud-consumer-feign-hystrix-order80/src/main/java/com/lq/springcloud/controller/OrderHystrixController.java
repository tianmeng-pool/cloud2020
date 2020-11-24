package com.lq.springcloud.controller;

import com.lq.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/7
 */
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
@RestController
public class OrderHystrixController {

    @Autowired
    private PaymentFeignService feignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String reslut = feignService.paymentInfo_OK(id);
        return reslut;
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        String reslut = feignService.paymentInfo_TimeOut(id);
        return reslut;
    }

    public String paymentInfo_TimeOutFallBack(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒后再试或者自己运行出错请检查自己o(╥﹏╥)o";
    }

    /**
     * 下面是全局Fallback方法
     */
    public String paymentGlobalFallBackMethod() {
        return "Global异常处理信息，请稍后再试";
    }
}
