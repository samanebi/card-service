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
        Card sourceCard = cardOperationService.findCard(transaction.getSource());
        Card destCard = cardOperationService.findCard(transaction.getDest());
        User source = sourceCard.getOwner();
        User dest = destCard.getOwner();
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
        return new TransactionResponse("success" , "no error");
    }
    public SmsResponse SmsRequest(SmsRequest smsRequest){
        String address = environment.getProperty("sms-service.address");
        return webclientService.smsPayment(smsRequest).block();
    }

}
