package com.sz.springcloud.service.controller;

import com.sz.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }

    @GetMapping(value = "/send")
    public String send(){
        return "sdfs";
    }
}
