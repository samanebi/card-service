package com.cardservice.demo.repository;

import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction , Long> {
    Transaction findByDestination_CardNumber(String card);

}
