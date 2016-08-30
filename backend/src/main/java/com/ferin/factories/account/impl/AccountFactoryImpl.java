package com.ferin.factories.account.impl;


import com.ferin.domain.account.Account;
import com.ferin.domain.client.Client;
import com.ferin.factories.account.AccountFactory;

import java.util.Map;

public class AccountFactoryImpl implements AccountFactory{

    @Override
    public Account createAccount(Map<String, Object> accountDetails) {
        return new Account.Builder()
                .accountNumber(accountDetails.get("accountNumber").toString())
                .accountType(accountDetails.get("accountType").toString())
                .balance(accountDetails.get("balance").toString())
                .limit(accountDetails.get("limit").toString())
                .pin(accountDetails.get("pin").toString())
                .client((Client) accountDetails.get("client"))
                .id(Long.parseLong(accountDetails.get("id").toString()))
                .build();
    }
}
