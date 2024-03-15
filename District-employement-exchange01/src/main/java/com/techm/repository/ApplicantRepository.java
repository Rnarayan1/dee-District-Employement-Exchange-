package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    // Custom queries if needed
	
	Applicant findByUsername(String username);
	
	Applicant findById(long id);
}
