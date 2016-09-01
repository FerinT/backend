package com.ferin.services.login.impl;

import com.ferin.domain.login.Login;
import com.ferin.repository.login.LoginRepository;
import com.ferin.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public Login create(Login entity) {
        return loginRepository.save(entity);
    }

    @Override
    public Login readById(Long aLong) {
        return loginRepository.findOne(aLong);
    }

    @Override
    public Set<Login> readAll() {
        Set<Login> result = new HashSet<Login>();

        Iterator iterator = loginRepository.findAll().iterator();
        while (iterator.hasNext())
            result.add((Login) iterator.next());
        return result;
    }

    @Override
    public Login update(Login entity) {
        return loginRepository.save(entity);
    }

    @Override
    public void delete(Login entity) {
        loginRepository.delete(entity);
    }
}
