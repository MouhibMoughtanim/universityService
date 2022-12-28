package com.example.universityservice.controller;

import com.example.universityservice.Service.ClientService;
import com.example.universityservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/allClients")
    public Iterable<Client> getAllClients(){
        return clientService.getAllClients();
    }

}
