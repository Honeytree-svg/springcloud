package com.sz.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){

        return "线程池：" + Thread.currentThread().getName()+" PaymentInfo_OK,   id"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池：" + Thread.currentThread().getName()+" paymentInfo_Timeout,   id"+id;
    }

    public String paymentinfo_TimeoutHandler(Integer id){

        return "线程池：" + Thread.currentThread().getName()+" paymentinfo_TimeoutHandler,   id"+id;
    }
}
