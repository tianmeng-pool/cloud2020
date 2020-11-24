package com.lq.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianmeng
 * @date 2020/11/5
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RandomRule();
    }
}
