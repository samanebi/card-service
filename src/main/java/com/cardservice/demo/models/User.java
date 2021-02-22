package com.cardservice.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table("user")
public class User {

    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String lastname;
    @OneToMany(mappedBy = "owner")
    private Set<Card> cards;
    @Column(unique=true)
    private String username;
    private String password;
    @Column(unique=true)
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cards=" + cards +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void overwrite(User user){
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.username = user.getUsername();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
