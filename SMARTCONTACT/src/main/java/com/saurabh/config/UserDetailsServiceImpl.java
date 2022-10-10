package com.saurabh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.saurabh.entities.User;
import com.saurabh.repository.UserRepository;

//method 2 -> which implements userdetailsservice method
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// we want the user to be loaded from database;
		User user = userRepository.getUserByUserName(username);
		if (user == null) {
			// can't get user from db ;
			throw new UsernameNotFoundException("can't find user");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
