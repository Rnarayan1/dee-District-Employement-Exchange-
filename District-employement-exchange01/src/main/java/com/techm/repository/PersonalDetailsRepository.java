package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    // Custom queries if needed
}