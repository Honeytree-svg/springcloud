package com.sz.springcloud.controller;

import com.sz.springcloud.entity.CommonResult;
import com.sz.springcloud.entity.Payment;
import com.sz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("******插入结果:" + result);
        if (result >0){

            return new CommonResult<>(200,"插入数据库成功,serverPort:" + serverPort,result);
        }else {
            return new CommonResult<>(400,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果:" + payment);
        if (payment !=null){

            return new CommonResult<>(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult<>(400,"查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String s :
                services) {

            log.info(s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:
             instances) {
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());

        }

        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){

        return  serverPort;
    }

    @GetMapping(value = "/payment/feign/tiemout")
    public String paymentTimeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  serverPort;
    }

    @GetMapping(value = "/payment/zipkin")
    public String getPaymentZipkin(){

        return  "sdfsfdfsfdfsfsdffs!!!!!!!--------------------";
    }
}
