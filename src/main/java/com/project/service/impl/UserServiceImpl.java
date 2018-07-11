package com.project.service.impl;

import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername( String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    public User findById( Long id ) throws AccessDeniedException {
        User u = userRepository.findOne( id );
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    public boolean insertOrSaveUser(User user) {
		this.userRepository.save(user);
		return true;
	}
    public boolean updateSaveUser(User user) {
		this.userRepository.save(user);
		return true;
	}
    
    public boolean deleteUser(Long id) throws AccessDeniedException {
  		if (this.userRepository.exists(id) ){
  			this.userRepository.delete(id);
  			return true;
        }
        else{
        	return true;
        }
  	}
	public boolean addUser(User user) {
		User newUser = this.userRepository.findByUsername(user.getUsername());
		
		//String newUser = user.getUsername();
		if (newUser==null || newUser.getUsername()=="" ) {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			this.insertOrSaveUser(user);
			return true;
		}
		else{
			return false;			
		}
	}

	public boolean updateUser(User user) {
		User searchUser = this.userRepository.findByUsername(user.getUsername());
		//String newUser = user.getUsername();
		if (searchUser != null) {
			String newPassword = user.getPassword();
			if(newPassword == null){
				user.setPassword(searchUser.getPassword());
			}else{
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));				
				
			}
			this.updateSaveUser(user);
			return true;
		}
		else{
			return false;
			
		}
	}	
  }
