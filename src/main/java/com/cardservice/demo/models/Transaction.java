package com.cardservice.demo.models;




public class Transaction {

    private Card source;
    private Card destination;
    private Integer amount;




    public Transaction(Card source, Card destination, Integer amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;

    }





    public Card getDestination() {
        return destination;
    }
    public void setDestination(Card destination) {
        this.destination = destination;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Card getSource() {
        return source;
    }

}
