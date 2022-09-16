package com.nagarro.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Role;
import com.nagarro.model.User;
import com.nagarro.model.UserRole;
import com.nagarro.repo.UserRepository;
import com.nagarro.service.UserService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")  // for working with the angular frontend
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// adding api
	
//	creating the user
	@PostMapping("/") /* "/user/" */
	public User createUser(@RequestBody User user) throws Exception {
		user.setProfile("default.png");
		Set<UserRole> roles = new HashSet<>();
		
		//encoded password with bcryptPasswordEncoder;
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		// creating a role
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");

		// set the user;
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		roles.add(userRole);
		return this.userService.createUser(user, roles);

	}

	// get the user 
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	// delete the user by id ;
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userid)
	{
		this.userService.deleteUser(userid);
	}


}
