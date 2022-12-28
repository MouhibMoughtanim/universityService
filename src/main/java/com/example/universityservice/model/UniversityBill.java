package com.example.universityservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class UniversityBill extends Bill{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Value("0")
    private int status;


}
