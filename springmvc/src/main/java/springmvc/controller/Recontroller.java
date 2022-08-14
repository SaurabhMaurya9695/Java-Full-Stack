package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Recontroller {

	@RequestMapping("/one")
	public String one() {
		
		System.out.println("Hey There we are in one now");
		return "redirect:/enjoy";
	}
	
	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("Hey There we are in enjoy now");
		return "contact";
	}
}
