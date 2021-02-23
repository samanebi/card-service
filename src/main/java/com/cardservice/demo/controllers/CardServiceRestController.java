package com.cardservice.demo.controllers;


import com.cardservice.demo.models.Card;
import com.cardservice.demo.models.User;
import com.cardservice.demo.services.CardOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardServiceRestController {

    @Autowired
    private CardOperationService cardOperationService;

    @RequestMapping("/add")
    public Boolean addCart(@RequestBody Card card){
        return cardOperationService.add(card);
    }

    @RequestMapping("/delete")
    public Boolean deleteCart(@RequestBody Card card){
        cardOperationService.delete(card);
        return true;
    }

    @RequestMapping("/list")
    public Object listCards(User user){
        return cardOperationService.findCardByUserPhone(user.getPhoneNumber());
    }


}
