package com.lq.springcloud.mapper;

import com.lq.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Mapper
public interface OrderMapper {

    void createOrder(Order order);

    void updateOrderStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
