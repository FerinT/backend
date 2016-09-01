package com.ferin.client;

import com.ferin.domain.login.Login;
import com.ferin.services.Service;
import com.ferin.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
public class UserLoginController {

    @Autowired
    private LoginService loginService;

    //------------------- Create a Client --------------------------------------------------------
    @RequestMapping(value = "/login-request/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStory(@RequestBody Login login, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating request for: " + login.getUsername());
        loginService.create(login);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client-request/{id}").buildAndExpand(login.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Retrieve Single Client --------------------------------------------------------
    @RequestMapping(value = "/login-request/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Login> getStory(@PathVariable("id") long id) {
        Login login = (Login) loginService.readById(id);
        if (login == null) {
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Login>(login, HttpStatus.OK);
    }

    //------------------- Update a Client --------------------------------------------------------

    @RequestMapping(value = "/login-request/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Login> updateStory(@PathVariable("id") long id, @RequestBody Login login) {

        Login currentClient = (Login) loginService.readById(id);

        if (currentClient==null) {
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }

        Login updatedClient = new Login.Builder()
                .copy(currentClient)
                .password(login.getUser_password())
                .username(login.getUsername())
                .build();
        loginService.update(updatedClient);
        return new ResponseEntity<Login>(updatedClient, HttpStatus.OK);
    }


    //------------------- Retrieve All Clients --------------------------------------------------------
    @RequestMapping(value = "/login-requests/", method = RequestMethod.GET)
    public ResponseEntity<Set<Login>> getStories() {
        Set<Login> requests = loginService.readAll();
        if(requests.isEmpty()){
            return new ResponseEntity<Set<Login>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Login>>(requests, HttpStatus.OK);
    }

    //------------------- Delete a Client --------------------------------------------------------
    @RequestMapping(value = "/login-request/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Login> deleteStory(@PathVariable("id") long id) {
        Login request = (Login) loginService.readById(id);
        if (request == null) {
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
        loginService.delete(request);
        return new ResponseEntity<Login>(HttpStatus.NO_CONTENT);
    }

}
