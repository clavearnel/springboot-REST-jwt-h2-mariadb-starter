package com.project.service;

import com.project.model.User;

import java.util.List;


public interface UserService {
    public User findById(Long id);
    public User findByUsername(String username);
    public List<User> findAll ();
	public boolean addUser(User user);
	public boolean deleteUser(Long userId);
	public boolean updateUser(User user);
}
