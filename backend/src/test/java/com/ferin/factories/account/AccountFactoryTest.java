package com.ferin.factories.account;


import com.ferin.domain.account.Account;
import com.ferin.domain.client.Client;
import com.ferin.factories.account.impl.AccountFactoryImpl;
import com.ferin.factories.client.ClientFactory;
import com.ferin.factories.client.impl.ClientFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class AccountFactoryTest {

  /*  @Test
    public void testAccountCreation() throws Exception {

        ClientFactory clientFactory = new ClientFactoryImpl();
        HashMap<String, String> clientData = new HashMap<String, String>();

        clientData.put("idNumber","9403300314082");
        clientData.put("name","Ferin");
        clientData.put("surname","Taylor");
        clientData.put("email","ft@gmail.com");
        clientData.put("membershipType","Student");
        clientData.put("id","1");

        Client client = clientFactory.createClient(clientData);


        AccountFactory accountFactory = new AccountFactoryImpl();
        HashMap<String, Object> accountData = new HashMap<String, Object>();

        accountData.put("accountNumber", "123");
        accountData.put("accountType","Savings");
        accountData.put("balance","500.00");
        accountData.put("limit","100.00");
        accountData.put("pin","123");
        accountData.put("client", client);
        accountData.put("id", "1");

        Account account = accountFactory.createAccount(accountData);

        Assert.assertEquals(account.getBalance(), new Double(500.00), 0);

    } */
}
