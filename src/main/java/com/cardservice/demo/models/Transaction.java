package com.cardservice.demo.models;


import com.cardservice.demo.repository.CardRepository;
import com.cardservice.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

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


    public Integer execute(CardRepository cardRepository){
        Integer result = 100;
        try {
            Card dest = cardRepository.findCardByCardNumber(this.destination);
            Integer decreaseBalanceResult = this.source.decreaseBalance(amount);
            Integer increaseBalanceResult = dest.increaseBalance(amount);

            if (!decreaseBalanceResult.equals(100)){
                result = decreaseBalanceResult;
            }
            else if (!increaseBalanceResult.equals(100)){
                result = increaseBalanceResult;
            }
        }
        catch (NullPointerException e){
            result = 110;
            e.printStackTrace();
        }
        catch (Exception e){
            result = 120;
            e.printStackTrace();
        }

        return result;
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
    public Long getSequence() {
        return sequence;
    }
    public Card getSource() {
        return source;
    }

}
