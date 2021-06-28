package com.example.accountsmanager.entity;

import java.math.BigDecimal;

public class Event {
    private String type;
    private String origin;
    private String destination;
    private BigDecimal amount;

    public Event(){
        this.type = "unknown";
        this.origin = "0";
        this.destination = "0";
        this.amount = new BigDecimal("0.0");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", origin=" + origin +
                ", destination=" + destination +
                ", amount=" + amount +
                '}';
    }
}
