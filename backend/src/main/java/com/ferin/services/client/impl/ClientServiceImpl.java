package com.ferin.services.client.impl;


import com.ferin.domain.client.Client;
import com.ferin.repository.client.ClientRepository;
import com.ferin.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client create(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client readById(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Set<Client> readAll() {
        Set<Client> result = new HashSet<Client>();

        Iterator iterator = clientRepository.findAll().iterator();
        while (iterator.hasNext())
            result.add((Client) iterator.next());
        return result;
    }

    @Override
    public Client update(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public void delete(Client entity) {
        clientRepository.delete(entity);
    }
}
