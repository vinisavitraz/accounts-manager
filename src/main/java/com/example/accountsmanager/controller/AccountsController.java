package com.example.accountsmanager.controller;

import com.example.accountsmanager.business.AccountsBusiness;
import com.example.accountsmanager.entity.Event;
import com.example.accountsmanager.exception.AccountNotFoundException;
import com.example.accountsmanager.exception.UnknownTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AccountsController {

    private AccountsBusiness business;

    public AccountsController(){
        this.business = new AccountsBusiness();
    }

    @RequestMapping(value = "/reset", method = POST)
    @ResponseBody
    public ResponseEntity <?> reset(){
        return generateResponse(200, this.business.reset());
    }

    @RequestMapping(value = "/balance", method = GET)
    @ResponseBody
    public ResponseEntity <?> getBalance(@RequestParam(name = "account_id") String accountId){
        try {
            return generateResponse(200, this.business.getBalance(accountId));
        } catch (AccountNotFoundException e) {
            return generateResponse(404, 0);
        }
    }

    @RequestMapping(value = "/event", method = POST)
    @ResponseBody
    public ResponseEntity <?> processEvent(@RequestBody Event event){
        try {
            return generateResponse(201, this.business.processEvent(event));
        } catch (AccountNotFoundException e) {
            return generateResponse(404, 0);
        } catch (UnknownTypeException e) {
            return generateResponse(400, e.getMessage());
        }
    }

    private ResponseEntity<?> generateResponse(Integer status, Object body){
        return ResponseEntity.status(status).body(body);
    }
}
