package com.cardservice.demo.repository;

import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction , Long> {

}
