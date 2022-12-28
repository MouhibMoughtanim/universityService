package com.example.universityservice.Service;

import com.example.universityservice.Repository.UniversityBillRepository;
import com.example.universityservice.Repository.UniversityRepository;
import com.example.universityservice.model.University;
import com.example.universityservice.model.UniversityBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;


    public Iterable<University> findAll(){
        return universityRepository.findAll();
    }

    public Optional<University> findById(int id){
        return universityRepository.findById(id);
    }

    public University save(University university){
        return universityRepository.save(university);
    }

    public void delete(int id){
        universityRepository.deleteById(id);
    }


}
