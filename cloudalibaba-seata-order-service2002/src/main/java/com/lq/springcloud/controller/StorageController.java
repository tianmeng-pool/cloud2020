package com.lq.springcloud.controller;

import com.lq.springcloud.entity.CommonResult;
import com.lq.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/desc")
    CommonResult desc(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.desc(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
