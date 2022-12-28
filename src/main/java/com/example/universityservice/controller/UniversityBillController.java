package com.example.universityservice.controller;

import com.example.universityservice.Service.ClientService;
import com.example.universityservice.Service.UniversityBillService;
import com.example.universityservice.model.Client;
import com.example.universityservice.model.UniversityBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universityBill")
@CrossOrigin
public class UniversityBillController {

    @Autowired
    private UniversityBillService universityBillService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/allUniversitiesBills")
    public Iterable<UniversityBill> getAllUniversities() {
        return universityBillService.findAll();
    }

    @GetMapping("/universityBillById/{id}")
    public UniversityBill getUniversityById(@PathVariable int id) {
        Optional<UniversityBill> universityBill = universityBillService.findById(id);
        if (universityBill.isPresent()) {
            return universityBill.get();
        } else {
            return null;
        }
    }


    @PostMapping("/saveUniveristyBill")
    public UniversityBill saveUniversity(@RequestBody UniversityBill universityBill) {
        return universityBillService.save(universityBill);
    }

    @PutMapping("/putUniversityBill/{id}")
    public UniversityBill updateUniversity(@PathVariable("id") final int id, @RequestBody UniversityBill universityBill) {
        System.out.println("updated");
        Optional<UniversityBill> universityBillOptional = universityBillService.findById(id);
        if (universityBillOptional.isPresent()) {

            UniversityBill currentUniversityBill = universityBillOptional.get();

            String reference = universityBill.getReference();
            if (reference != null) {
                currentUniversityBill.setReference(reference);
            }

            Long price = universityBill.getPrice();
            if (price != null) {
                currentUniversityBill.setPrice(price);
            }
            //  Date date = universityBill.getDate();
            //if(date != null){
            //  currentUniversityBill.setDate(java.sql.Date.valueOf(String.valueOf(date)));
            //}
            Client client = universityBill.getClient();
            if (client != null) {
                currentUniversityBill.setClient(client);
            }
            int status = universityBill.getStatus();
                currentUniversityBill.setStatus(status);



            universityBillService.save(currentUniversityBill);
            return currentUniversityBill;
        } else {
            return null;
        }

    }

    @DeleteMapping("/deleteUniversityBill/{id}")
    public void deleteUniversityBill(@PathVariable("id") final int id) {
        universityBillService.delete(id);
    }

    @GetMapping("/universityBillsById/{id}")
    public List<UniversityBill> getUniversityBillsById(@PathVariable("id") final int id) {
        return universityBillService.getUniversityBillsByUniversityId(id);
    }

    @GetMapping("/universityBillsById/{id}/status/{bol}")
    public List<UniversityBill> getUniversityBillsByIdAndStatus(@PathVariable("id") final int id, @PathVariable("bol") final boolean bol) {
        return universityBillService.getUniversityBillsByUniversityIdAndStatus(id, bol);
    }

    @GetMapping("/universityBillsContains/{s}")
    public List<UniversityBill> getUniversityBillsById(@PathVariable("s") final String s) {
        return universityBillService.getUniversityBillsByReference(s);
    }
        @GetMapping("/universityBillsByUniversityAndContains/{id}/{s}")
    public List<UniversityBill> getUniversityBillsByUniversityAndReference(@PathVariable("id") int id,@PathVariable("s") final String s) {
        Optional<UniversityBill> uOpt = universityBillService.findById(id);
        UniversityBill u = uOpt.get();
        return universityBillService.getUniversityBillsByUniversityAndReference(u,s);
    }

            @GetMapping("/universityBillByClientId/{id}")
    public List<UniversityBill> getUniversitiesBillsByClientId(@PathVariable int id) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return universityBillService.getUniversityBillsByClient(client);
        } else {
            return null;
        }

    }

    @GetMapping("/universityBillByClientId/{id}/orderBydate")
    public List<UniversityBill> getUniversitiesBillsByClientIdOrderByDate(@PathVariable int id) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return universityBillService.getUniversityBillsByClientOrderByDate(client);
        } else {
            return null;
        }

    }

    @GetMapping("universityBills/numberOfBills/ByMounth")
    public List getNumberOfBillsPayedAndUnpayedByMounth(){
        return universityBillService.getNumberOfBillsPayedAndUnpayedByMounth();
    }
    @GetMapping("universityBills/total")
    public List getTotalSumOfUnpayedAndUnpayed(){
        return universityBillService.getTotalSumOfUnpayedAndUnpayed();
    }
}
