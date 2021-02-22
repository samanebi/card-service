package com.cardservice.demo.repository;

import com.cardservice.demo.models.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TransactionRepository extends CrudRepository<Transaction , Long> {

    Transaction findBySequence(Long id);
    Set<Transaction> findBySource_CardNumber(String card);
    Set<Transaction> findByDestination(String card);

}
