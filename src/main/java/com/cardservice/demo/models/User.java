package com.cardservice.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table("user")
public class User {

    @Id
    @GeneratedValue
    private Long id;



    @OneToMany(mappedBy = "owner")
    private Set<Card> cards;
    @Column(unique=true)
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +

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
}
