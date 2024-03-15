package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByUsername(String username);

}
