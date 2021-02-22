package com.cardservice.demo.models;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;
import java.util.logging.Logger;

@Entity
@Table("card")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String cardNumber;
    private Integer balance;
    @ManyToOne
    @JoinColumn(name = "id" , nullable = false)
    private User owner;
    private String cvv2;
    private Calendar expireDate;
    private String pin;
    @OneToMany(mappedBy = "source")
    private Set<Transaction> transaction;


    public void overwrite(Card card){
        this.cvv2 = card.cvv2;
        this.expireDate = card.expireDate;
        this.pin = card.pin;
    }


    public Integer increaseBalance(Integer amount){
        Integer result = 100;
        if (amount >= 0){
            this.balance = this.balance + amount;
        }
        else {
            result = 101;
            Logger.getGlobal().severe("amount is not valid");
        }

        return result;
    }

    public Integer decreaseBalance(Integer amount){
        Integer  result = 100;
        if (amount >= 0 && this.balance >= amount){
            this.balance = this.balance - amount;
        }
        else if(amount < 0) {
            result = 102;
            Logger.getGlobal().severe("amount is not valid");
        }
        else {
            result = 103;
            Logger.getGlobal().severe("not enough money");
        }

        return result;
    }

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

    public String getPin() {
        return pin;
    }
}
