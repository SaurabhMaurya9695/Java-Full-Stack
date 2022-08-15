package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/home")
//	@ResponseBody
	public String home() {
		System.out.println("this is  new home page ");
		return "home";
	}
}
