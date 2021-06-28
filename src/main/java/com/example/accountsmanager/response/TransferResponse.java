package com.example.accountsmanager.response;

import com.example.accountsmanager.entity.Account;

public class TransferResponse extends Response {
    private Account origin;
    private Account destination;

    public TransferResponse(Account origin, Account destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }
}
