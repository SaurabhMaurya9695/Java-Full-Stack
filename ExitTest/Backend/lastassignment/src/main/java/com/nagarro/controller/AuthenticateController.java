package com.nagarro.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.config.JwtUtil;
import com.nagarro.model.JwtRequest;
import com.nagarro.model.JwtResponse;
import com.nagarro.model.User;
import com.nagarro.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*") // to unblocked all the backedn apis
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil ;
	
	
//	genertae tokens
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateTokens(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User not found..from Authenticatecont");
		}
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	/*get the currrent User details*/
	@GetMapping("/current-user")
	public User getCurrentuser(Principal principal)
	{
		return (User) this.userDetailsService.loadUserByUsername(principal.getName());
	}

	private void authenticate(String username , String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLE" + e.getMessage());
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID CREDENTIALS" + e.getMessage());
		}
	}
}
