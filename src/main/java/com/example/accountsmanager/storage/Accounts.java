package com.example.accountsmanager.storage;

import com.example.accountsmanager.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class Accounts {
    private static Accounts instance;
    private Map<String, Account> accounts;

    public synchronized static Accounts getInstance() {
        if (Accounts.instance == null) {
            Accounts.instance = new Accounts();
        }
        return Accounts.instance;
    }

    public Accounts(){
        this.accounts = new HashMap<>();
    }

    public Map<String, Account> getAccounts() {
        return this.accounts;
    }

    public Account getAccount(String accountId){
        return this.accounts.get(accountId);
    }

    public void addAccount(Account account){
        this.accounts.put(account.getId(), account);
    }

    public boolean hasAccounts(){
        return this.accounts.values().size() > 0;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}
