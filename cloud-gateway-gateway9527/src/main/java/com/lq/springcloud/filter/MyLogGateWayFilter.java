package com.lq.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author tianmeng
 * @date 2020/11/8
 */
@Slf4j
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("com in MyLogGateWayFilter: " + LocalDateTime.now());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null)
            throw new RuntimeException("用户名不能为null");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
