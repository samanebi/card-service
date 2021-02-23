package com.cardservice.demo.repository;

import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface CardRepository extends CrudRepository<Card , Long> {

    Card findCardByCardNumber(String card);
    Set<Card> findCardsByOwner_PhoneNumber(String phone);
}
