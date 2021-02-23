package com.cardservice.demo.models;

import javax.persistence.*;

@Entity
@Table("card")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String cardNumber;
    @ManyToOne
    @JoinColumn(name = "id" , nullable = false)
    private User owner;




    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", owner=" + owner +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public User getOwner() {
        return owner;
    }


}
