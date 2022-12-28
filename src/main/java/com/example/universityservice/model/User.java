package com.example.universityservice.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String password;
    private Date date_naissance;
    @Column(unique = true)
    private String phone;
    private String agence;
    private String type;


    public User(String nom, String prenom, String email, String password, Date date_naissance, String phone, String agence) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.date_naissance = date_naissance;
        this.phone = phone;
        this.agence = agence;
        this.type = "Agent";
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}