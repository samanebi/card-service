package com.cardservice.demo.services;

import com.cardservice.demo.models.*;
import com.cardservice.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TransactionOperationService {


    @Autowired
    private WebclientService webclientService;
    @Autowired
    private Environment environment;
    @Autowired
    private UserOperationService userOperationService;
    @Autowired
    private CardOperationService cardOperationService;
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponse execute(TransactionRequest transaction){
        //todo : 2 payment services
        TransactionResponse transactionResponse = this.paymentRequest(transaction);
        User source = userOperationService.findUserByCard(transaction.getSource());
        User dest = userOperationService.findUserByCard(transaction.getDest());
        Card sourceCard = cardOperationService.findCard(transaction.getSource());
        Card destCard = cardOperationService.findCard(transaction.getDest());
        //todo : sms provider
        if (!transactionResponse.getResult().equals("failed")){
            Transaction transactionResult = new Transaction(sourceCard , destCard , transaction.getAmount());
            transactionRepository.save(transactionResult);
            SmsResponse smsResponseOwner = this.SmsRequest(
                    new SmsRequest("money from to your account" , source.getPhoneNumber()));
            SmsResponse smsResponseDest = this.SmsRequest(
                    new SmsRequest("money transferred to your account" ,dest.getPhoneNumber()));

        }

        return transactionResponse;
    }

    public TransactionResponse paymentRequest(TransactionRequest transaction){
        String address1 = environment.getProperty("payment-provider1.address");
        String address2 = environment.getProperty("payment-provider2.address");
        Mono<TransactionResponse> result = null;
        if (transaction.getSource().substring(0,4).equals("6037")){
            result = webclientService.requestPayment(transaction , address1);
        }
        else{
            result = webclientService.requestPayment(transaction , address2);
        }
        return result.block();
    }
    public SmsResponse SmsRequest(SmsRequest smsRequest){
        String address = environment.getProperty("sms-provider.adderss");
        return webclientService.smsPayment(smsRequest , address).block();
    }

}
