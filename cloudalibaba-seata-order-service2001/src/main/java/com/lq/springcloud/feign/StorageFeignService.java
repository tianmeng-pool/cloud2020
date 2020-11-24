package com.lq.springcloud.feign;

import com.lq.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignService {

    @PostMapping("/storage/desc")
    CommonResult desc(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
