package com.ferin.client;

import com.ferin.domain.account.Account;
import com.ferin.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by student on 2016/08/27.
 */
@RestController
public class AccountController {
    @Autowired
    private Service accountService;

    //------------------- Create a Client --------------------------------------------------------
    @RequestMapping(value = "/account-request/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStory(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating request for: " + account.getAccountNumber());
        accountService.create(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client-request/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Retrieve Single Client --------------------------------------------------------
    @RequestMapping(value = "/account-request/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getStory(@PathVariable("id") long id) {
        Account client = (Account) accountService.readById(id);
        if (client == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(client, HttpStatus.OK);
    }

    //------------------- Update a Client --------------------------------------------------------

    @RequestMapping(value = "/account-request/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateStory(@PathVariable("id") long id, @RequestBody Account account) {

        Account currentClient = (Account) accountService.readById(id);

        if (currentClient==null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

        Account updatedAccount = new Account.Builder()
                .copy(currentClient)
                .pin(account.getPin())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .account_limit(account.account_limit())
                .build();
        accountService.update(updatedAccount);
        return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
    }


    //------------------- Retrieve All Clients --------------------------------------------------------
    @RequestMapping(value = "/account-requests/", method = RequestMethod.GET)
    public ResponseEntity<Set<Account>> getStories() {
        Set<Account> requests = accountService.readAll();
        if(requests.isEmpty()){
            return new ResponseEntity<Set<Account>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Account>>(requests, HttpStatus.OK);
    }

    //------------------- Delete a Client --------------------------------------------------------
    @RequestMapping(value = "/account-request/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteStory(@PathVariable("id") long id) {
        Account request = (Account) accountService.readById(id);
        if (request == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        accountService.delete(request);
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }
}
