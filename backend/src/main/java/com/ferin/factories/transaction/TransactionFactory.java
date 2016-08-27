package com.ferin.factories.transaction;

import com.ferin.domain.transaction.Transaction;
import com.ferin.domain.transaction.impl.BalanceEnquiry;
import com.ferin.domain.transaction.impl.Deposit;
import com.ferin.domain.transaction.impl.Withdraw;


public class TransactionFactory {
    public static Transaction getTransaction(String value){
        Transaction chain = setUpchain();
        return chain.handleRequest(value);
    }

    public static Transaction setUpchain(){
        Transaction balanceEnquiry = new BalanceEnquiry();
        Transaction deposit = new Deposit();
        Transaction withdraw = new Withdraw();

        balanceEnquiry.setNextTransaction(deposit);
        deposit.setNextTransaction(withdraw);

        return balanceEnquiry;
    }
}
