package com.example.accountsmanager.entity;

import java.math.BigDecimal;

public class Account {
    private String id;
    private BigDecimal balance;

    public Account() {
        this.id = "0";
        this.balance = new BigDecimal("0.0");
    }

    public Account(String id, BigDecimal balance){
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
