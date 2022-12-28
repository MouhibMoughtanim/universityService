package com.example.universityservice;

import com.example.universityservice.Service.UniversityBillService;
import com.example.universityservice.model.UniversityBill;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class UniversityServiceApplication  {

    @Autowired
    private UniversityBillService universityBillService;


    public static void main(String[] args) {
        SpringApplication.run(UniversityServiceApplication.class, args);
    }


    }

