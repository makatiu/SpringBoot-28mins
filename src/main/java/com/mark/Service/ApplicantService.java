package com.mark.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mark.Dao.ApplicantDao;
import com.mark.Entity.Applicant;
import com.mark.Repository.ApplicantRepository;

@Service
public class ApplicantService {

//	@Autowired
//	@Qualifier("postgres")
//	private ApplicantDao applicantDao;
//	
	@Autowired
	private ApplicantRepository repository;
	
	public Iterable<Applicant> getAllApplicants(){
		//return applicantDao.getAllApplicants();
		
		return repository.findAll();
	}

	public Applicant getApplicantById(int id) {
		
		return repository.findOne(id);
		
		//return applicantDao.getApplicantById(id);
	}

	public void removeApplicantById(int id) {
		
		repository.delete(id);
		//applicantDao.removeApplicantById(id);
	}

	public void updateApplicant(Applicant applicant) {
		
		Applicant temp = repository.findOne(applicant.getId());
		temp.setName(applicant.getName());
		temp.setDestination(applicant.getDestination());
		repository.save(temp);
		//applicantDao.updateApplicant(applicant);
		
	}

	public void insertApplicant(Applicant applicant) {
		//applicantDao.insertApplicant(applicant);
		
		Applicant temp = new Applicant();
		temp.setName(applicant.getName());
		temp.setDestination(applicant.getDestination());
		repository.save(temp);
	}

}
