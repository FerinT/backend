package com.ferin.factories.transaction;


import com.ferin.domain.account.Account;
import com.ferin.domain.client.Client;
import com.ferin.domain.transaction.Transaction;
import com.ferin.domain.transaction.impl.Deposit;
import com.ferin.factories.account.AccountFactory;
import com.ferin.factories.account.impl.AccountFactoryImpl;
import com.ferin.factories.client.ClientFactory;
import com.ferin.factories.client.impl.ClientFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TransactionFactoryTest {
  /*  @Test
    public void testTransctionChain() throws Exception {
        Transaction transfer = TransactionFactory.getTransaction("transfer");

        Assert.assertSame(new Deposit().getClass(), transfer.getClass());
    }

    @Test
    public void testBalanceEnquiry() throws Exception {
        AccountFactory accountFactory = new AccountFactoryImpl();
        ClientFactory clientFactory = new ClientFactoryImpl();
        HashMap<String, String> clientData = new HashMap<String, String>();

        clientData.put("idNumber","9403300314082");
        clientData.put("name","Ferin");
        clientData.put("surname","Taylor");
        clientData.put("email","ft@gmail.com");
        clientData.put("membershipType","Student");
        clientData.put("id","1");

        Client client = clientFactory.createClient(clientData);

        HashMap<String, Object> accountData = new HashMap<String, Object>();

        accountData.put("accountNumber", "123");
        accountData.put("accountType","Savings");
        accountData.put("balance","500.00");
        accountData.put("limit","100.00");
        accountData.put("pin","123");
        accountData.put("client", client);
        accountData.put("id", "1");

        Account account = accountFactory.createAccount(accountData);

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("account", account);

        Transaction balanceEnquiry = TransactionFactory.getTransaction("BalanceEnquiry");

        Assert.assertTrue(balanceEnquiry.performTransaction(data));
    }

    @Test
    public void testWithdraw() throws Exception {
        AccountFactory accountFactory = new AccountFactoryImpl();
        ClientFactory clientFactory = new ClientFactoryImpl();
        HashMap<String, String> clientData = new HashMap<String, String>();

        clientData.put("idNumber","9403300314082");
        clientData.put("name","Ferin");
        clientData.put("surname","Taylor");
        clientData.put("email","ft@gmail.com");
        clientData.put("membershipType","Student");
        clientData.put("id","1");

        Client client = clientFactory.createClient(clientData);

        HashMap<String, Object> accountData = new HashMap<String, Object>();

        accountData.put("accountNumber", "123");
        accountData.put("accountType","Savings");
        accountData.put("balance","500.00");
        accountData.put("limit","100.00");
        accountData.put("pin","123");
        accountData.put("client", client);
        accountData.put("id", "1");

        Account account = accountFactory.createAccount(accountData);

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("account", account);
        data.put("amount", new Double(150.00));

        Transaction withdraw = TransactionFactory.getTransaction("withdraw");

        Assert.assertTrue(withdraw.performTransaction(data));
    }

    @Test
    public void testDeposit() throws Exception {
        AccountFactory accountFactory = new AccountFactoryImpl();
        ClientFactory clientFactory = new ClientFactoryImpl();
        HashMap<String, String> clientData = new HashMap<String, String>();

        clientData.put("idNumber","9403300314082");
        clientData.put("name","Ferin");
        clientData.put("surname","Taylor");
        clientData.put("email","ft@gmail.com");
        clientData.put("membershipType","Student");
        clientData.put("id","1");

        Client client = clientFactory.createClient(clientData);

        HashMap<String, Object> accountData = new HashMap<String, Object>();

        accountData.put("accountNumber", "123");
        accountData.put("accountType","Savings");
        accountData.put("balance","500.00");
        accountData.put("limit","100.00");
        accountData.put("pin","123");
        accountData.put("client", client);
        accountData.put("id", "1");

        Account account = accountFactory.createAccount(accountData);

        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put("account", account);
        data.put("amount", new Double(150.00));

        Transaction deposit = TransactionFactory.getTransaction("deposit");

        Assert.assertTrue(deposit.performTransaction(data));
    } */
}
