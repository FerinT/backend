package com.ferin.factories.client.impl;

import com.ferin.domain.client.Client;
import com.ferin.factories.client.ClientFactory;

import java.util.Map;

/**
 * Created by student on 2016/08/17.
 */
public class ClientFactoryImpl implements ClientFactory{

    public Client createClient(Map<String, String> clientData) {
      return new Client.Builder()
              .idNumber(clientData.get("idNumber"))
              .name(clientData.get("name"))
              .surname(clientData.get("surname"))
              .email(clientData.get("email"))
              .membershipType(clientData.get("membershipType"))
              .id(Long.parseLong(clientData.get("id")))
              .build();
    }
}
