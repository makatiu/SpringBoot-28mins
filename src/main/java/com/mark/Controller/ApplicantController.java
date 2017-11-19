package com.mark.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mark.Entity.Applicant;
import com.mark.Service.ApplicantService;

@RestController
@RequestMapping("/Applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicantService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Applicant> getAllApplicants(){
		return service.getAllApplicants();
	}
	
	@RequestMapping("/{id}")
	public Applicant getApplicantById(@PathVariable("id") int id) {
		return service.getApplicantById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeApplicantById(@PathVariable("id") int id) {
		service.removeApplicantById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateApplicant(@RequestBody Applicant applicant)
	{
		service.updateApplicant(applicant);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertApplicant(@RequestBody Applicant applicant)
	{
		service.insertApplicant(applicant);
	}

}
