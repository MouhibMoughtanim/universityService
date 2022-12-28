package com.example.universityservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String cin;
    private String telephone;
    private String email;

    private String address;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    List<UniversityBill> universityBills = new ArrayList<>();

    public void addUniversityBill(UniversityBill universityBill) {
        universityBills.add(universityBill);
        universityBill.setClient(this);
    }

    public void removeUniversityBill(UniversityBill  universityBill) {
        universityBills.remove(universityBill);
        universityBill.setUniversity(null);
    }
}
