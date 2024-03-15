package com.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techm.entity.Job;

import jakarta.transaction.Transactional;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Custom queries if needed
	
	@Modifying
    @Transactional
    @Query("UPDATE Job j SET j.applicationStatus = 'Closed' WHERE j.id = ?1")
    void closeJobById(Long jobId);
	
	@Query("SELECT j FROM Job j WHERE j.qualificationRequired = :qualification")
    List<Job> findByQualification(@Param("qualification") String qualification);
}
