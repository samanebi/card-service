package com.cardservice.demo.models;
import com.cardservice.demo.enums.CardOperation;

public class CardServiceRequest {

    private String card;
    private String phoneNumber;



    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
