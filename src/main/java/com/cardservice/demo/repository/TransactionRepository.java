package com.cardservice.demo.repository;

import com.cardservice.demo.models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction , Long> {


}
