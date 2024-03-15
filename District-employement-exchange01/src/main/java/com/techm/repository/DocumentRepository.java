package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    // Custom queries if needed
}
