package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.EducationalDetails;

public interface EducationalDetailsRepository extends JpaRepository<EducationalDetails, Long> {
    // Custom queries if needed
}

