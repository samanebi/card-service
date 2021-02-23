package com.cardservice.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cardId;

    @Column(unique = true)
    private String cardNumber;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId" )
    private User owner;




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
}
