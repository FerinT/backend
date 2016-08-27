package com.ferin.client;

import com.ferin.domain.client.Client;
import com.ferin.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    private Service clientService;

    //------------------- Create a Client --------------------------------------------------------
    @RequestMapping(value = "/client-request/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStory(@RequestBody Client client, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating request for: " + client.getName());
        clientService.create(client);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client-request/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Retrieve Single Client --------------------------------------------------------
    @RequestMapping(value = "/client-request/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getStory(@PathVariable("id") long id) {
        Client client = (Client) clientService.readById(id);
        if (client == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    //------------------- Update a Client --------------------------------------------------------

    @RequestMapping(value = "/client-request/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateStory(@PathVariable("id") long id, @RequestBody Client client) {

        Client currentClient = (Client) clientService.readById(id);

        if (currentClient==null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        Client updatedClient = new Client.Builder()
                .copy(currentClient)
                .membershipType(client.getMembershipType())
                .idNumber(client.getIdNumber())
                .email(client.getEmail())
                .surname(client.getSurname())
                .name(client.getName())
                .build();
        clientService.update(updatedClient);
        return new ResponseEntity<Client>(updatedClient, HttpStatus.OK);
    }


    //------------------- Retrieve All Clients --------------------------------------------------------
    @RequestMapping(value = "/client-requests/", method = RequestMethod.GET)
    public ResponseEntity<Set<Client>> getStories() {
        Set<Client> requests = clientService.readAll();
        if(requests.isEmpty()){
            return new ResponseEntity<Set<Client>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Client>>(requests, HttpStatus.OK);
    }

    //------------------- Delete a Client --------------------------------------------------------
    @RequestMapping(value = "/client-request/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteStory(@PathVariable("id") long id) {
        Client request = (Client) clientService.readById(id);
        if (request == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        clientService.delete(request);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }


}
