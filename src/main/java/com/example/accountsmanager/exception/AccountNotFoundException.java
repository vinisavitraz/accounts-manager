package com.example.accountsmanager.exception;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String accountId){
        super("Account with ID '" + accountId + "' not found.");
    }
}
