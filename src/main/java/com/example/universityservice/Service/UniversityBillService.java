package com.example.universityservice.Service;

import com.example.universityservice.Repository.UniversityBillRepository;

import com.example.universityservice.Repository.UniversityRepository;
import com.example.universityservice.model.Client;
import com.example.universityservice.model.UniversityBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityBillService {
    @Autowired
    public UniversityBillRepository universityBillRepository;
    @Autowired
    private UniversityRepository universityRepository;

    public Iterable<UniversityBill> findAll() {
        return universityBillRepository.findAll();
    }

    public Optional<UniversityBill> findById(int id) {
        return universityBillRepository.findById(id);
    }

    public UniversityBill save(UniversityBill universityBill) {
        return universityBillRepository.save(universityBill);
    }

    public void delete(int id) {
        UniversityBill u = findById(id).get();
        u.setUniversity(null);
        u.setClient(null);
        universityBillRepository.deleteById(id);
    }

    public List<UniversityBill> getUniversityBillsByUniversityId(int id) {
        return universityBillRepository.findAllByUniversity_Id(id);
    }

    public List<UniversityBill> getUniversityBillsByUniversityIdAndStatus(int id, boolean bol) {
        return universityBillRepository.findAllByUniversity_IdAndStatus(id, bol);
    }

    public List<UniversityBill> getUniversityBillsByReference(String s) {
        return universityBillRepository.findUniversityBillByReferenceContains(s);
    }

    public List<UniversityBill> getUniversityBillsByClient(Client c) {
        return universityBillRepository.findUniversityBillByClient(c);
    }

    public List<UniversityBill> getUniversityBillsByClientOrderByDate(Client c) {
        return universityBillRepository.findUniversityBillByClientOrderByDateDesc(c);
    }

    public List getTotalSumOfUnpayedAndUnpayed() {
        return universityBillRepository.getTotalSumOfUnpayedAndUnpayed();
    }

    public List getNumberOfBillsPayedAndUnpayedByMounth() {
        return universityBillRepository.getNumberOfBillsPayedAndUnpayedByMounth();
    }

    public List<UniversityBill> getUniversityBillsByUniversityAndReference(UniversityBill u ,String s) {
       return universityBillRepository.findUniversityBillByUniversityAndReferenceContains(u,s);
    }
}