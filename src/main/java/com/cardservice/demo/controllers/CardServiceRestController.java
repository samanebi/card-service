package com.cardservice.demo.controllers;


import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.CardServiceRequest;
import com.cardservice.demo.models.User;
import com.cardservice.demo.services.CardOperationService;
import com.cardservice.demo.services.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardServiceRestController {

    @Autowired
    private CardOperationService cardOperationService;
    @Autowired
    private UserOperationService userOperationService;

    @RequestMapping("/add")
    public Boolean addCart(@RequestBody CardServiceRequest card){
        Card temp = new Card();
        temp.setCardNumber(card.getCard());
        temp.setOwner(userOperationService.findUserByPhone(card.getPhoneNumber()));
        return cardOperationService.add(temp);
    }

    @RequestMapping("/delete")
    public Boolean deleteCart(@RequestBody CardServiceRequest card){

        cardOperationService.delete(cardOperationService.findCard(card.getCard()));
        return true;
    }

    @RequestMapping("/list")
    public Object listCards(@RequestBody User user){
        return cardOperationService.findCardByUserPhone(user.getPhoneNumber());
    }



}
