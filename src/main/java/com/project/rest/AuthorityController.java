package com.project.rest;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import com.project.model.Authority;
import com.project.service.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class AuthorityController {
	@Autowired
    private AuthorityService authorityService;	
	
    @RequestMapping( method = GET, value= "/authority/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Authority> loadAll() {
        return this.authorityService.findAll();
    }    
}
