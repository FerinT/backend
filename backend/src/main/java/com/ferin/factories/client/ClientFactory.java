package com.ferin.factories.client;

import com.ferin.domain.client.Client;

import java.util.Map;

/**
 * Created by student on 2016/08/17.
 */
public interface ClientFactory {
    public Client createClient(Map<String, String> clientData);
}
