package com.project.rest;

import com.project.model.User;
import com.project.model.UserHistory;
import com.project.service.UserService;
import com.project.data.UserToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( method = GET, value = "/user/{userId}" )
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById( @PathVariable Long userId ) {
        return this.userService.findById( userId );
    }


    @RequestMapping( method = GET, value = "/user" ,produces = {"application/json"})
     @PreAuthorize("hasRole('ADMIN')")
    public User getUserByUsername(@RequestParam String username) {    	
        return this.userService.findByUsername(username);
    }

    @RequestMapping( method = GET, value= "/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }
    
    @RequestMapping( method = POST, value= "/user/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean deleteUser( @PathVariable Long userId ) {
        return this.userService.deleteUser( userId );
        
    }

 
  @RequestMapping(value = "/user/create", method = POST, produces = {"application/json"})
  @PreAuthorize("hasRole('ADMIN')")
	public User addNewUser(@RequestBody User user, HttpServletRequest req) {
		boolean userAddSuccess = userService.addUser(user);
		if (userAddSuccess==true){
			return user;
		}
		else{
			return user;
		}
	}
  
  @RequestMapping(value = "/user/update", method = POST, produces = {"application/json"})
  @PreAuthorize("hasRole('ADMIN')")
	public boolean updateUser(@RequestBody User user, HttpServletRequest req) {
		boolean userAddSuccess = userService.updateUser(user);
		if (userAddSuccess==true){
			return true;
		}
		else{
			return false;
		}
	}

    @RequestMapping("/whoami")
    public User user(Principal user) {    	
        return this.userService.findByUsername(user.getName());
    }
}
