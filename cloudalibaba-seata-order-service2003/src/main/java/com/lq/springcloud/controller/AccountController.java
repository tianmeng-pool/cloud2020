package com.lq.springcloud.controller;

import com.lq.springcloud.entity.CommonResult;
import com.lq.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/desc")
    CommonResult desc(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.desc(userId, money);
        return new CommonResult(200, "余额扣减成功");
    }
}
