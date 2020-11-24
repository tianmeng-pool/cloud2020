package com.lq.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tianmeng
 * @date 2020/11/6
 */
public interface LoadBalance {
    /**
     * 获取所有的服务实例
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
