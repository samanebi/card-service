package com.cardservice.demo.services;

import com.cardservice.demo.interfaces.EntityOperationService;
import com.cardservice.demo.models.Transaction;
import com.cardservice.demo.repository.CardRepository;
import com.cardservice.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TransactionOperationService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    public Boolean execute(Transaction transaction){
        Boolean result = true;
        Integer resultCode = transaction.execute(cardRepository);
        if (!result.equals(100)){
            result = false;
        }
        else {
            transactionRepository.save(transaction);
        }
        return result;
    }
    public Set<Transaction> findByDest(String dest){
        return transactionRepository.findByDestination(dest);
    }
    public Set<Transaction> findBySource(String source){
        return transactionRepository.findBySource_CardNumber(source);
    }
    public Transaction findBySeq(Long sequence){
        return transactionRepository.findBySequence(sequence);
    }

}
