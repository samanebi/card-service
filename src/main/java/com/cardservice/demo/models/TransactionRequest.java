package com.cardservice.demo.models;

public class TransactionRequest {

    private String source;
    private String dest;
    private String cvv2;
    private String expDate;
    private String pin;
    private Integer amount;

    public TransactionRequest(String source, String dest, String cvv2, String expDate, String pin, Integer amount) {
        this.source = source;
        this.dest = dest;
        this.cvv2 = cvv2;
        this.expDate = expDate;
        this.pin = pin;
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
