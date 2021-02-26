package com.smsservice.demo.services;


import com.smsservice.demo.models.SmsRequest;
import com.smsservice.demo.models.SmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
    private WebClientService webClientService;

    public SmsResponse send(SmsRequest smsRequest){
        //return webClientService.send(smsRequest).block();
        return new SmsResponse("success");
    }

}
