package com.lq.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@MapperScan(basePackages = "com.lq.springcloud.mapper")
@Configuration
public class MybatisConfig {
}
