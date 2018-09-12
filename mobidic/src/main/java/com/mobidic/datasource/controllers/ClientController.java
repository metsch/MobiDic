package com.mobidic.datasource.controllers;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.mobidic.datasource.models.Client;
import com.mobidic.datasource.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/clients")
public class ClientController {

    public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        Client client = clientRepository.findById(id).get();
        logger.info(client.toString());
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }
}