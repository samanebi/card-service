package com.cardservice.demo.services;


import com.cardservice.demo.enums.CardOperation;
import com.cardservice.demo.interfaces.EntityOperationService;
import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.User;
import com.cardservice.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CardOperationService implements EntityOperationService<Card> {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public boolean add(Card entity) {
        Card temp = cardRepository.save(entity);
        return temp != null;
    }

    @Override
    public boolean addAll(Iterable<Card> entities) {
        Iterable<Card> temp = cardRepository.saveAll(entities);
        return temp != null;
    }

    @Override
    public void delete(Card entity) {
        cardRepository.delete(entity);
    }

    // todo : find solution for delete functions

    @Override
    public void deleteAll(Iterable<Card> entities) {
        cardRepository.deleteAll(entities);
    }

    @Override
    public Boolean update(Card entity, Card value) {
        return null;
    }


    public Card findCard(String card){
        return cardRepository.findCardByCardNumber(card);
    }

    public Iterable<Card> findCardByUserPhone(String phone){
        return cardRepository.findCardsByOwner_PhoneNumber(phone);

    }



}
