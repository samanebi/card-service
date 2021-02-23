package com.cardservice.demo.services;


import com.cardservice.demo.models.SmsResponse;
import com.cardservice.demo.models.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebclientService {


    @Autowired
    private WebClient webClient;

    public Mono<TransactionResponse> requestPayment(Object bodyValue , String uri){
        return  webClient
                .post()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(TransactionResponse.class);
    }

    public Mono<SmsResponse> smsPayment(Object bodyValue , String uri){
        return  webClient
                .post()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(SmsResponse.class);
    }



}
