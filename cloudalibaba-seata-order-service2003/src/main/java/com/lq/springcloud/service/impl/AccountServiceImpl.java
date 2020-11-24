package com.lq.springcloud.service.impl;

import com.lq.springcloud.mapper.AccountMapper;
import com.lq.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void desc(Long userId, BigDecimal money) {

        // int age = 10 / 0;
        accountMapper.desc(userId, money);
    }
}
