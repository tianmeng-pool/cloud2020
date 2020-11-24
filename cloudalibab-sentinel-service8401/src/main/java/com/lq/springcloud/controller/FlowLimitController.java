package com.lq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author tianmeng
 * @date 2020/11/15
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        /*try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        /*try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD测试    RT");*/
        log.info("testD 测试异常比例");
        int age = 10 / 0;
        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "-------testE 测试异常数";
    }

    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int i = 10 / 0;
        return "-------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "-------deal_testHotKey";
    }
}
