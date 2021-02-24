package com.cardservice.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Long txId;

    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "soursCardId" , updatable = false)
    private Card source;
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "destCardId", updatable = false)
    private Card destination;
    private Integer amount;
    private Long timestamp;




    public Transaction(Card source, Card destination, Integer amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();

    }


    public Transaction() {
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

    public void setSource(Card source) {
        this.source = source;
    }

    public Long getTimestamp() {
        return timestamp;
    }


}
