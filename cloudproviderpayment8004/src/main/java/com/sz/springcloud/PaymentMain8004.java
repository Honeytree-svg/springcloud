package com.sz.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.sz.springcloud.dao")
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8004.class,args);
    }
}
