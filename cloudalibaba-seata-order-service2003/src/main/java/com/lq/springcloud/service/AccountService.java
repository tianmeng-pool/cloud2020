package com.lq.springcloud.service;


import java.math.BigDecimal;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
public interface AccountService {

    void desc(Long userId, BigDecimal money);
}
