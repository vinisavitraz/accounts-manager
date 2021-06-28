package com.example.accountsmanager.business;

import com.example.accountsmanager.entity.Account;
import com.example.accountsmanager.entity.Event;
import com.example.accountsmanager.entity.Operation;
import com.example.accountsmanager.exception.AccountNotFoundException;
import com.example.accountsmanager.exception.UnknownTypeException;
import com.example.accountsmanager.response.DepositResponse;
import com.example.accountsmanager.response.Response;
import com.example.accountsmanager.response.TransferResponse;
import com.example.accountsmanager.response.WithdrawResponse;
import com.example.accountsmanager.storage.Accounts;

import java.math.BigDecimal;
import java.util.HashMap;

public class AccountsBusiness {

    private Accounts accounts;

    public AccountsBusiness(){
        this.accounts = Accounts.getInstance();
    }

    public String reset(){
        this.accounts.setAccounts(new HashMap<>());
        return "OK";
    }

    public BigDecimal getBalance(String accountId) throws AccountNotFoundException {
        Account account = accounts.getAccount(accountId);

        if(account != null){
            return account.getBalance();
        } else{
            throw new AccountNotFoundException(accountId);
        }
    }

    public Response processEvent(Event event) throws AccountNotFoundException, UnknownTypeException {
        Operation operation = Operation.fromName(event.getType());

        switch (operation){
            case DEPOSIT:
                return deposit(event);
            case WITHDRAW:
                return withdraw(event);
            case TRANSFER:
                return transfer(event);
            default:
                throw new UnknownTypeException(event.getType());
        }
    }

    private DepositResponse deposit(Event event){
        Account destination = this.accounts.getAccount(event.getDestination());

        if(destination == null){
            destination = new Account(event.getDestination(), event.getAmount());
        } else{
            add(destination, event.getAmount());
        }

        save(destination);

        return new DepositResponse(destination);
    }

    private WithdrawResponse withdraw(Event event) throws AccountNotFoundException {
        Account origin = this.accounts.getAccount(event.getOrigin());

        if(origin != null){
            subtract(origin, event.getAmount());
            save(origin);
            return new WithdrawResponse(origin);
        } else{
            throw new AccountNotFoundException(event.getOrigin());
        }
    }

    private TransferResponse transfer(Event event) throws AccountNotFoundException {
        Account origin = this.accounts.getAccount(event.getOrigin());

        if(origin != null){
            Account destination = this.accounts.getAccount(event.getDestination());
            subtract(origin, event.getAmount());

            if(destination != null){
                add(destination, event.getAmount());
            } else{
                destination = new Account(event.getDestination(), event.getAmount());
            }

            save(origin);
            save(destination);

            return new TransferResponse(origin, destination);
        } else{
            throw new AccountNotFoundException(event.getOrigin());
        }
    }

    private void save(Account account){
        this.accounts.addAccount(account);
    }

    private void add(Account account, BigDecimal amount){
        account.setBalance(account.getBalance().add(amount));
    }

    private void subtract(Account account, BigDecimal amount){
        account.setBalance(account.getBalance().subtract(amount));
    }
}
