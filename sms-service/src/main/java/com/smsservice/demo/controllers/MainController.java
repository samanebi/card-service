package com.smsservice.demo.controllers;


import com.smsservice.demo.models.SmsRequest;
import com.smsservice.demo.models.SmsResponse;
import com.smsservice.demo.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("/sms")
    public SmsResponse sendSms(@RequestBody SmsRequest smsRequest){
        return smsService.send(smsRequest);
    }
}
