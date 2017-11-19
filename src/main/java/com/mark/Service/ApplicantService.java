package com.mark.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mark.Dao.ApplicantDao;
import com.mark.Entity.Applicant;

@Service
public class ApplicantService {

	@Autowired
	@Qualifier("postgres")
	private ApplicantDao applicantDao;
	
	public Collection<Applicant> getAllApplicants(){
		return applicantDao.getAllApplicants();
	}

	public Applicant getApplicantById(int id) {
		return applicantDao.getApplicantById(id);
	}

	public void removeApplicantById(int id) {
		applicantDao.removeApplicantById(id);
	}

	public void updateApplicant(Applicant applicant) {
		applicantDao.updateApplicant(applicant);
		
	}

	public void insertApplicant(Applicant applicant) {
		applicantDao.insertApplicant(applicant);
		
	}

}
