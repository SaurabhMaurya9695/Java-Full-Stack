package com.nagarro.service;

import java.util.Set;

import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.nagarro.model.User;
import com.nagarro.model.UserRole;


public interface UserService {

	//create user
	public User createUser(User user , Set<UserRole> userRoles) throws Exception;
	
	//get user by username ;
	public  User getUser(String username);
	
//	Delete  user by id;
	public void deleteUser(Long userId); 
	
}
