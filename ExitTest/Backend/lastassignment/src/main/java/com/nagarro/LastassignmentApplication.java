package com.nagarro;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nagarro.model.Role;
import com.nagarro.model.User;
import com.nagarro.model.UserRole;
import com.nagarro.service.UserService;


@SpringBootApplication
public class LastassignmentApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(LastassignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

		// creating user information
//		User user = new User();
//		user.setFirstName("Saurabh");
//		user.setLastName("Maurya");
//		user.setEmail("saurabhyash1707@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("ADMIN"));
//		user.setPhone("6392272716");
//		user.setUsername("Saurabh Maurya");
//
//		// creating role information
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		// set the userrole and user into the set
//		Set<UserRole> userRolesSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRolesSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRolesSet);
//		System.out.println(user1.getUsername());

	}

}
