package com.example.accountsmanager.response;

import com.example.accountsmanager.entity.Account;

public class WithdrawResponse extends Response {
    private Account origin;

    public WithdrawResponse(Account origin){
        this.origin = origin;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }
}
