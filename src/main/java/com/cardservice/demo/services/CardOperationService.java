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

    @Override
    public void deleteAll(Iterable<Card> entities) {
        cardRepository.deleteAll(entities);
    }

    @Override
    public Boolean update(Card entity, Card value) {
        Card temp = null;
        if (entity.getCardNumber().equals(value.getCardNumber()) &&
            entity.getId().equals(value.getId())){
            entity.overwrite(value);
            temp = cardRepository.save(entity);
        }

        return temp != null;
    }

    public Integer increaseAmount(Card card , Integer amount){
        Integer result = 100;
        if (card != null && card.getPin() != null){

            Integer resultCode = card.increaseBalance(amount);
            if (!resultCode.equals(100)){
                result = resultCode;

            }
        }
        else if (card == null){
            result = 110 ;
            Logger.getGlobal().severe("null value passed : card");
        }
        else {
            result = 110 ;
            Logger.getGlobal().severe("null value passed : pin");
        }

        return result;
    }

    public Integer decreaseAmount(Card card , Integer amount){
        Integer result = 100;
        if (card != null && card.getPin() != null){

            Integer resultCode = card.decreaseBalance(amount);
            if (!resultCode.equals(100)){
                result = resultCode;

            }
        }
        else if (card == null){
            result = 110 ;
            Logger.getGlobal().severe("null value passed : card");
        }
        else {
            result = 110 ;
            Logger.getGlobal().severe("null value passed : pin");
        }

        return result;
    }

    public Card findCard(String card){
        return cardRepository.findCardByCardNumber(card);
    }

    public Iterable<Card> findCard(User user){
        return cardRepository.findCardsByOwner_Username(user.getUsername());

    }



}
