package com.example.accountsmanager.exception;

public class UnknownTypeException extends Exception {
    public UnknownTypeException(String type){
        super("Type '" + type + "' not found.");
    }
}
