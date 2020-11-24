package com.lq.springcloud.service.impl;

import com.lq.springcloud.mapper.StorageMapper;
import com.lq.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void desc(Long productId, Integer count) {
        storageMapper.desc(productId,count);
    }
}
