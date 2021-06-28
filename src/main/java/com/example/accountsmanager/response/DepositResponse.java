package com.example.accountsmanager.response;

import com.example.accountsmanager.entity.Account;

public class DepositResponse extends Response {

    private Account destination;

    public DepositResponse(Account destination){
        this.destination = destination;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }
}
