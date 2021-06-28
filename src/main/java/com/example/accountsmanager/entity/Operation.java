package com.example.accountsmanager.entity;

public enum Operation {
    UNKNOWN("unknown"),
    WITHDRAW("withdraw"),
    DEPOSIT("deposit"),
    TRANSFER("transfer"),
    BALANCE("balance");

    private String name;

    Operation(String name){
        this.name = name;
    }

    public static Operation[] allValues = values();

    public static Operation fromName(String name){
        for(int i=0;i<allValues.length;i++) {
            if (name.equalsIgnoreCase(allValues[i].getName())) {
                return allValues[i];
            }
        }

        return UNKNOWN;
    }

    public String getName() {
        return name;
    }
}
