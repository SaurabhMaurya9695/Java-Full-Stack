package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
//	@ResponseBody

	public String about(Model model) {
		System.out.println("I'm from about");
		model.addAttribute("name", "Saurabh Maurya");
		return "about";
	}
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) 
	{
//		model.addAttribute("isActive" , true);
		model.addAttribute("gender" , "F");
		System.out.println("I'm Executed");
		return "condition";
	}
	
	@GetMapping("/Services")
	public String ServicesHandler(Model model) 
	{
		System.out.println("I'm Executed from service");
		return "service";
	}
	@GetMapping("/newabout")
	public String newAboutHandler(Model model) 
	{
		System.out.println("I'm Executed from newAbout");
		return "aboutnew";
	}
	
}
