package com.example.universityservice.controller;

import com.example.universityservice.Repository.UniversityRepository;
import com.example.universityservice.Service.UniversityService;
import com.example.universityservice.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/university")
@CrossOrigin
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/allUniversities")
    public Iterable<University> getAllUniversities(){
        return universityService.findAll();
    }

    @GetMapping("/universityById/{id}")
    public University getUniversityById(@PathVariable int id){
        Optional<University> university = universityService.findById(id);
        if(university.isPresent()) {
            return university.get();
        } else {
            return null;
        }
    }

    @PostMapping("/saveUniversity")
    public University saveUniversity(@RequestParam("logo") MultipartFile logo,
                                     @RequestParam("nom") String nom,
                                     @RequestParam("description") String description,
                                     @RequestParam("site") String site,
                                     @RequestParam("video") String video){
        University university = new University();
        String fileName = StringUtils.cleanPath(logo.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            university.setLogo(Base64.getEncoder().encodeToString(logo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        university.setNom(nom);
        university.setDescription(description);
        university.setSite(site);
        university.setVideo(video);

        return universityService.save(university);
    }

    @PutMapping("/putUniversity/{id}")
    public University updateUniversity(@PathVariable("id") final int id, @RequestParam("logo") MultipartFile logo,
                                       @RequestParam("nom") String nom,
                                       @RequestParam("description") String description) throws IOException {
        University university = new University();
        String fileName = StringUtils.cleanPath(logo.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            university.setLogo(Base64.getEncoder().encodeToString(logo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        university.setNom(nom);
        university.setDescription(description);


                 Optional<University> universityOptional = universityService.findById(id);
                 if(universityOptional.isPresent()){
                  University currentUniversity = universityOptional.get();
                  String nomm = university.getNom();
                  if(nomm != null) {
                    currentUniversity.setNom(nomm);
                  }
                  String logoo= university.getLogo();
                     if(logoo != null) {
                         currentUniversity.setLogo(Base64.getEncoder().encodeToString(logo.getBytes()));
                     }
                  String descriptionn = university.getDescription();
                if(descriptionn != null) {
                    currentUniversity.setDescription(descriptionn);
                }
                     String videoo = university.getVideo();
                     if(videoo != null) {
                         currentUniversity.setVideo(videoo);
                     }
                     String sitee = university.getSite();
                     if(sitee != null) {
                         currentUniversity.setSite(sitee);
                     }
                universityService.save(currentUniversity);
                return currentUniversity;
                 } else {
                     return null;
                 }

            }

    @DeleteMapping("/deleteUniversity/{id}")
    public void deleteUniversity(@PathVariable("id") final int id){
        universityService.delete(id);
    }




}
