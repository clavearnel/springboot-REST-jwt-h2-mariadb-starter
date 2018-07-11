package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}