package com.saurabh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saurabh.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// create a custom method to get user by username;
	@Query("select u from User u where u.email = :email") // write same as this :email
	public User getUserByUserName(@Param("email") String email);

}
