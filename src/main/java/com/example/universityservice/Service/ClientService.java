package com.example.universityservice.Service;

import com.example.universityservice.Repository.ClientRepository;
import com.example.universityservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getAllClients(){
        return clientRepository.findAll();
    }


    public Optional<Client> findById(int id){
      return clientRepository.findById(id);
    }
}
