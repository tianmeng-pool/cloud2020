package com.lq.springcloud.feign;

import com.lq.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignService {

    @PostMapping("/account/desc")
    CommonResult desc(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
