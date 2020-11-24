package com.lq.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lq.springcloud.entities.CommonResult;
import com.lq.springcloud.entities.Payment;

/**
 * @author tianmeng
 * @date 2020/11/16
 */
public class CustomerBlockHandler {

    public static CommonResult<Payment> handlerException(BlockException e){
        return new CommonResult<>(444,"global handlerException-----1");
    }

    public static CommonResult<Payment> handlerException2(BlockException e){
        return new CommonResult<>(444,"global handlerException2-----2");
    }
}
