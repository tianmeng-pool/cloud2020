package com.lq.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Mapper
public interface AccountMapper {

    void desc(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
