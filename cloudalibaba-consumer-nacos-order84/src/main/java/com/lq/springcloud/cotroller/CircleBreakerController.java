package com.lq.springcloud.cotroller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
@Slf4j
@RestController
public class CircleBreakerController {

    public static final String SERVER_URL = "http://cloud-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    // @SentinelResource(value = "fallback") // 没有配置
    // @SentinelResource(value = "fallback", fallback = "fallbackHandler")  // fallback只负责业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")  // blockHandler 只负责sentinel控制台违规配置
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    @GetMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallBack(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4)
            throw new IllegalArgumentException("非法的参数异常!!!");
        else if (result.getData() == null)
            throw new NullPointerException("没有对应值!!!");
        return result;
    }

    public CommonResult<Payment> fallbackHandler(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常，fallbackHandler" + e.getMessage(), payment);
    }

    public static CommonResult<Payment> blockHandler(BlockException e) {
        return new CommonResult<>(444, " blockHandler : " + e.getMessage());
    }

}
