package com.lq.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Mapper
public interface StorageMapper {

    /**
     * 扣库存
     * @param productId
     * @param count
     */
    void desc(@Param("productId") Long productId, @Param("count") Integer count);
}
