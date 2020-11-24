package com.lq.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianmeng
 * @date 2020/11/8
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        RouteLocator build = builder.routes()
                .route("cloud-gateway_lq", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();

        return build;
    }
}
