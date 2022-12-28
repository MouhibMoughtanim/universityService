package com.example.universityservice.Repository;

import com.example.universityservice.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer > {
}
