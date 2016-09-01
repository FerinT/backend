package com.ferin.services.account.impl;

import com.ferin.domain.account.Account;
import com.ferin.repository.account.AccountRepository;
import com.ferin.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class AccountserviceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account create(Account entity) {
        return accountRepository.save(entity);
    }

    @Override
    public Account readById(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Set<Account> readAll() {
        Set<Account> result = new HashSet<Account>();

        Iterator iterator = accountRepository.findAll().iterator();
        while (iterator.hasNext())
            result.add((Account) iterator.next());
        return result;
    }

    @Override
    public Account update(Account entity) {
        return accountRepository.save(entity);
    }

    @Override
    public void delete(Account entity) {
        accountRepository.delete(entity);
    }
}
