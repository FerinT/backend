package com.ferin.domain.transaction.impl;

import com.ferin.domain.account.Account;
import com.ferin.domain.transaction.Transaction;
import java.util.Map;

public class BalanceEnquiry extends Transaction{

    public BalanceEnquiry(){}

    @Override
    public boolean performTransaction(Map<String, Object> data) {
        Account account = (Account) data.get("account");

        System.out.println("Balance Enquiry for: " + account.getClient().getName());

        return account.getAccountNumber() != null;
    }

    @Override
    public Transaction handleRequest(String request) {
        if(request.equalsIgnoreCase("balanceEnquiry")){
            return new BalanceEnquiry();
        }
        else{
            if(nextTransaction != null){
                return nextTransaction.handleRequest(request);
            }
        }
        return null;
    }

}
