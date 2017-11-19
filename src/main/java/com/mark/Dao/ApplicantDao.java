package com.mark.Dao;

import java.util.Collection;

import com.mark.Entity.Applicant;

/**
 * @author mark
 * 
 * NOT BEING USED ANYMORE
 * 
 * Refer to ApplicantRepository.java
 *
 */
public interface ApplicantDao {

	Collection<Applicant> getAllApplicants();

	Applicant getApplicantById(int id);

	void removeApplicantById(int id);

	void updateApplicant(Applicant applicant);

	void insertApplicant(Applicant applicant);

}