package com.example.universityservice.Repository;

import com.example.universityservice.model.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<University,Integer> {
}
