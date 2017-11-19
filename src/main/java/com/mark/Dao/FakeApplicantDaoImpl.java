package com.mark.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mark.Entity.Applicant;

@Repository
@Qualifier("fakedata")
public class FakeApplicantDaoImpl implements ApplicantDao {

	private static Map<Integer, Applicant> applicants;

	static {
		applicants = new HashMap<Integer, Applicant>(){

			{
				put(1, new Applicant(1, "Mark", "Japan"));
				put(2, new Applicant(2, "Viel", "India"));
				put(3, new Applicant(3, "Jordan", "US"));
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see com.mark.Dao.ApplicantDao#getAllApplicants()
	 */
	@Override
	public Collection<Applicant> getAllApplicants(){
		return applicants.values();
	}

	/* (non-Javadoc)
	 * @see com.mark.Dao.ApplicantDao#getApplicantById(int)
	 */
	@Override
	public Applicant getApplicantById(int id) {
		return applicants.get(id);
	}

	/* (non-Javadoc)
	 * @see com.mark.Dao.ApplicantDao#removeApplicantById(int)
	 */
	@Override
	public void removeApplicantById(int id) {
		applicants.remove(id);
	}

	/* (non-Javadoc)
	 * @see com.mark.Dao.ApplicantDao#updateApplicant(com.mark.Entity.Applicant)
	 */
	@Override
	public void updateApplicant(Applicant applicant) {
		
		Applicant temp = applicants.get(applicant.getId());
		
		temp.setName(applicant.getName());
		temp.setDestination(applicant.getDestination());
		
	}

	/* (non-Javadoc)
	 * @see com.mark.Dao.ApplicantDao#insertApplicant(com.mark.Entity.Applicant)
	 */
	@Override
	public void insertApplicant(Applicant applicant) {
		applicants.put(applicant.getId(), applicant);
		
	}
}
