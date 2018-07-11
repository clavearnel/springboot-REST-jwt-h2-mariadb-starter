package com.project.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.UserData;
import com.project.model.Authority;
import com.project.model.User;
import com.project.service.UserService;

@Repository
@Transactional
public class UserDataDao {
    @Autowired
    private UserService userService;
    

	
    @PersistenceContext
    EntityManager em;
	public String getUser(String username, String password) {
		BigInteger a = null;
	try {		
		String queryString = "SELECT count(id) FROM USERS";

			queryString += " WHERE USERNAME = :username";
						
			Query query = em.createNativeQuery(queryString);
			
			query.setParameter("username", username);
			
			a = (BigInteger) query.getSingleResult();
			
					
		} catch(NoResultException e) {		
			//e.printStackTrace();
		}
			 if(a.intValue() > 0) {			 
			 }else{
				 User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					
					String jsonInString = "[{id: 2, name: 'ROLE_USER', authority: 'ROLE_USER'}]";
					JSONArray jsonArr = new JSONArray(jsonInString);
					List<Authority> authorities = new ArrayList<>();
					for (int i = 0; i < jsonArr.length(); i++) {
						JSONObject jsonObj = jsonArr.getJSONObject(i);
						Authority data = new Authority();

						data.setId(jsonObj.getInt("id"));
						data.setName(jsonObj.getString("name"));

						authorities.add(data);
					}
				
					user.setAuthorities(authorities);
					user.setEnabled(true);
					
					boolean userAddSuccess = userService.addUser(user);
					if (userAddSuccess==true){
					}
			 }
			return password;
	}
}
