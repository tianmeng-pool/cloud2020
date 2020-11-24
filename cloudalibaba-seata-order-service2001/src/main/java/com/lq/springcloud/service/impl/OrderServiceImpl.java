package com.lq.springcloud.service.impl;

import com.lq.springcloud.entity.Order;
import com.lq.springcloud.feign.AccountFeignService;
import com.lq.springcloud.feign.StorageFeignService;
import com.lq.springcloud.mapper.OrderMapper;
import com.lq.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    private StorageFeignService storageFeignService;

    private AccountFeignService accountFeignService;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, StorageFeignService storageFeignService, AccountFeignService accountFeignService) {
        this.orderMapper = orderMapper;
        this.storageFeignService = storageFeignService;
        this.accountFeignService = accountFeignService;
    }

    /**
     * 创建订单-->调用库存服务扣减库存-->调用账户服务扣减账户余额-->修改订单状态
     * 简单说:下订单-->扣库存-->减余额-->该状态
     */
    @GlobalTransactional(name = "order-create-transaction", rollbackFor = Exception.class)
    @Override
    public void createOrder(Order order) {
        log.info("开始创建订单!!!");
        orderMapper.createOrder(order);
        log.info("----->订单微服务开始调用库存，做扣减count");
        storageFeignService.desc(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");
        log.info("----->订单微服务开始调用账户，做扣减money");
        accountFeignService.desc(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");
        log.info("----->修改订单状态，从0改为1");
        orderMapper.updateOrderStatus(order.getUserId(), 0);
        log.info("----->订单创建结束!!!!");
    }

}
