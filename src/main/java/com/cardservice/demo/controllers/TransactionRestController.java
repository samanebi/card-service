package com.cardservice.demo.controllers;


import com.cardservice.demo.models.TransactionRequest;
import com.cardservice.demo.models.TransactionResponse;
import com.cardservice.demo.services.TransactionOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

    @Autowired
    private TransactionOperationService transactionOperationService;

    @RequestMapping("/execute")
    public TransactionResponse execute(@RequestBody TransactionRequest transactionRequest){
        return transactionOperationService.execute(transactionRequest);
    }



}
