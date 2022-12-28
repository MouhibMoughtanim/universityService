package com.example.universityservice.Repository;

import com.example.universityservice.model.Client;
import com.example.universityservice.model.UniversityBill;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UniversityBillRepository extends JpaRepository<UniversityBill,Integer> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "Delete from UniversityBill c WHERE c.id=:id")
    public void deleteById(@Param("id") int id);

    @Query(value = "select DATE_FORMAT(u.date,'%Y-%M') as date ,sum(u.status),count(u.id)-sum(u.status) from UniversityBill as u  GROUP BY date ORDER BY u.date DESC  ")
    public List getNumberOfBillsPayedAndUnpayedByMounth();
    @Query(value = "select  sum(u.price) from UniversityBill as u   GROUP BY u.status  ")
    public List getTotalSumOfUnpayedAndUnpayed();
    public List<UniversityBill> findAllByUniversity_Id(int id);
    public List<UniversityBill> findAllByUniversity_IdAndStatus(int id,boolean bol);

    public List<UniversityBill> findUniversityBillByReferenceContains(String s);
    public List<UniversityBill> findUniversityBillByUniversityAndReferenceContains(UniversityBill u,String s);
    public List<UniversityBill> findUniversityBillByClient(Client client);

    public List<UniversityBill> findUniversityBillByClientOrderByDateDesc(Client client);

}
