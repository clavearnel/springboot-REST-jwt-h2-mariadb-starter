package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Authority;
import com.project.repository.AuthorityRepository;
import com.project.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
    private AuthorityRepository authorityRepository;

	@Override
	public List<Authority> findAll() {
	    List<Authority> result = authorityRepository.findAll();
        return result;
	}

}
