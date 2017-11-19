package com.mark.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mark.Entity.Applicant;

@Repository("postgres")
public class PostGresApplicantDaoImpl implements ApplicantDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class ApplicantRowMapper implements RowMapper<Applicant>{

		@Override
		public Applicant mapRow(ResultSet rs, int rowNum) throws SQLException {
			Applicant applicant = new Applicant();
			applicant.setId(rs.getInt("id"));
			applicant.setName(rs.getString("name"));
			applicant.setDestination(rs.getString("destination"));
			return applicant;
		}
		
	}

	@Override
	public Collection<Applicant> getAllApplicants() {
		// TODO Auto-generated method stub

		final String sql = "SELECT * FROM applicant";
		List<Applicant> students = jdbcTemplate.query(sql, new ApplicantRowMapper());

		return students;
	}

	@Override
	public Applicant getApplicantById(int id) {
		
		final String sql = "SELECT * FROM applicant WHERE id = ? LIMIT 1";
		
		Applicant student = jdbcTemplate.queryForObject(sql, new ApplicantRowMapper(), id);
		
		return student;
	}

	@Override
	public void removeApplicantById(int id) {
		final String sql = "DELETE FROM applicant WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub

		final String sql = "UPDATE applicant SET name = ?, destination = ? WHERE id = ?";
		
		final int id = applicant.getId();
		final String name = applicant.getName();
		final String destination = applicant.getDestination();
		
		jdbcTemplate.update(sql, new Object[] {name, destination, id});
		
	}

	@Override
	public void insertApplicant(Applicant applicant) {
		// TODO Auto-generated method stub

final String sql = "INSERT INTO applicant (name, destination) VALUES (?, ?)";
		
		final int id = applicant.getId();
		final String name = applicant.getName();
		final String destination = applicant.getDestination();
		
		jdbcTemplate.update(sql, new Object[] {name, destination});
		
	}

}
