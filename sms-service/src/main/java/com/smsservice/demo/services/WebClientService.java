package com.smsservice.demo.services;


import com.smsservice.demo.models.SmsRequest;
import com.smsservice.demo.models.SmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private Environment environment;

    public Mono<SmsResponse> send(SmsRequest smsRequest){
        String address = environment.getProperty("sms-provider.address");
        Mono<SmsResponse> result = null;
        try {
            result = webClient
                    .post()
                    .uri(address)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(smsRequest)
                    .retrieve()
                    .bodyToMono(SmsResponse.class);
        }
        catch (WebClientResponseException e){

        }

        return  result;
    }
}
