package com.sz.springcloud.controller;

import com.sz.springcloud.entity.CommonResult;
import com.sz.springcloud.entity.Payment;
import com.sz.springcloud.service.PaymentFeignService;
import feign.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/tiemout")
    public String paymentTimeout(){

        //openfeign 客户端默认1s超时
        return paymentFeignService.paymentTimeout();
    }
}
