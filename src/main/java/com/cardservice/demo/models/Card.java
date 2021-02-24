package com.cardservice.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cardId;

    @Column(unique = true)
    private String cardNumber;
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User owner;

    @OneToMany(mappedBy = "destination")
    private Set<Transaction> transactionDest;

    @OneToMany(mappedBy = "source")
    private Set<Transaction> transactionSource;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", owner=" + owner +
                '}';
    }

    public Long getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Transaction> getTransactionDest() {
        return transactionDest;
    }

    public void setTransactionDest(Set<Transaction> transactionDest) {
        this.transactionDest = transactionDest;
    }

    public Set<Transaction> getTransactionSource() {
        return transactionSource;
    }

    public void setTransactionSource(Set<Transaction> transactionSource) {
        this.transactionSource = transactionSource;
    }
}
