package com.mark.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mark.Entity.Applicant;

@Service
public interface ApplicantRepository extends CrudRepository<Applicant, Integer>{

}
