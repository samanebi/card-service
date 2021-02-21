package com.cardservice.demo.models;

public class Transaction {


    private static Long sequence;
    private Card source;
    private String destination;
    private Integer amount;

    public Boolean execute(){


        sequence++;
        return true;
    }

    public Transaction(Card source, String destination, Integer amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        if (sequence == null){
            sequence = Long.valueOf(10000);
        }
    }


    public static Long getSequence() {
        return sequence;
    }

    public Card getSource() {
        return source;
    }

    public void setSource(Card source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
