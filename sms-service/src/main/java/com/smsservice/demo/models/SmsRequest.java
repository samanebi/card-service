package com.smsservice.demo.models;

public class SmsRequest {

    private String text;
    private String target;

    public SmsRequest(String text, String target) {
        this.text = text;
        this.target = target;
    }

    public SmsRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
