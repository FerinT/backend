package com.ferin.domain.transaction;

import java.util.Map;


public abstract class Transaction {
    public Transaction nextTransaction;

    public void setNextTransaction(Transaction nextTransaction){
        this.nextTransaction = nextTransaction;
    }

    public abstract Transaction handleRequest(String request);
    public abstract boolean performTransaction(Map<String, Object> data);
}
