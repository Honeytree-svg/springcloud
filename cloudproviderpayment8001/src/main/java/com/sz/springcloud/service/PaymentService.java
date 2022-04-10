package com.sz.springcloud.service;

import com.sz.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@PathVariable("id") Long id);

}
