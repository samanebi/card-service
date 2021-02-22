package com.cardservice.demo.models;


import javax.persistence.*;

@Entity
@Table("transaction")
@SequenceGenerator(name="TxSequence", initialValue=100000)
public class Transaction {





    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seqTxSequence")
    private Long sequence;
    @ManyToOne
    @JoinColumn(name = "id" , nullable = false)
    private Card source;
    private String destination;
    private Integer amount;

    public Boolean execute(){



        return true;
    }

    public Transaction(Card source, String destination, Integer amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;

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
