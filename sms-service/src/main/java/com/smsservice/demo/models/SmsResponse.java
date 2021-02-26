package com.smsservice.demo.models;

public class SmsResponse {

    private String status;

    public SmsResponse(String status) {
        this.status = status;
    }

    public SmsResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
