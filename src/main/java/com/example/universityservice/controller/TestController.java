package com.example.universityservice.controller;


import com.example.universityservice.Service.UniversityService;
import com.example.universityservice.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/university/")
    public Iterable<University> getAllUniversities(){
        return universityService.findAll();
    }
}