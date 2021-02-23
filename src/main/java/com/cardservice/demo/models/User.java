package com.cardservice.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @OneToMany(mappedBy = "owner")
    private Set<Card> cards;
    @Column(unique=true)
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +

                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void overwrite(User user){
        this.phoneNumber = user.getPhoneNumber();

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        for (Card card : cards){
            card.setOwner(this);
        }
        this.cards = cards;
    }

    public Long getUserId() {
        return userId;
    }

}
