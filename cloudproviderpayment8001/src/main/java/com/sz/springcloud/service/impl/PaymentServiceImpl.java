package com.sz.springcloud.service.impl;

import com.sz.springcloud.dao.PaymentDao;
import com.sz.springcloud.entity.Payment;
import com.sz.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource(name = "paymentDao")
    private PaymentDao paymentDao;

    @Override
    public int create(@RequestBody Payment payment){

        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id){

        return paymentDao.getPaymentById(id);
    }
}
