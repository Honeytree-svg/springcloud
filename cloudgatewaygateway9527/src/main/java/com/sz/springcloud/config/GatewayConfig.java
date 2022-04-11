package com.sz.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRoutes(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_sz",
                r->r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}
