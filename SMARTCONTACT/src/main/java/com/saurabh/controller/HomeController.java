package com.saurabh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saurabh.entities.User;
import com.saurabh.helper.Message;
import com.saurabh.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		System.out.println("working");
		User user = new User();
		user.setName("Saurabh Maurya");
		user.setEmail("saurabhyash1707@gmail.com");
		user.setPassword("Saurabh ");
		this.userRepository.save(user);
		return "Working";
	}

	/* Home page */
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home - SmartContactManager");
		return "home";
	}

	/* About page */
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - SmartContactManager");
		return "about";
	}

	/* Signup page */
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Signup - SmartContactManager");
		model.addAttribute("user", new User());// sending a new empty user to a form

		return "signup";
	}

	/* Handler for registring user page */
	/* @PostMapping("/do_register") */

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser( @ModelAttribute("user") User user, BindingResult result1,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session ) {
		try {
			if (agreement == false) {
				System.out.println("You haven't agreed the terms and conditions..");
				throw new Exception("You haven't agreed the terms and conditions..");

			}
			
			//setting the role of user ;
			user.setRole("ROLE_USER");
			user.setEnable(true);
			user.setImage("default.png");
			
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			
			User res = this.userRepository.save(user);
			System.out.println(user);
			model.addAttribute("user" , new User());
			session.setAttribute("message", new Message("Successfully Registered.." , "alert-success"));
			return "signup";
			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong !!" + e.getMessage() , "alert-danger"));
			return "signup";
		}
		
			
			
	}

	// handler for login page ;
	
	@GetMapping("/signin")
	public String customlogin(Model model)
	{
		model.addAttribute("title" , "Login Page");
		return "login";
	}
}
