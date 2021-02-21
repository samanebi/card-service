package com.cardservice.demo.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table("card")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String cardNumber;
    private Integer balance;
    private User owner;
    private String cvv2;
    private Calendar expireDate;


    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public String getCvv2() {
        return cvv2;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }
}
