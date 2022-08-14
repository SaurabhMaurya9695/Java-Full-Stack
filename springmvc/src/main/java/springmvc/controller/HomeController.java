package springmvc.controller;

import java.util.ArrayList;
import java.util.*;

//*********Step3********** 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	// TODO Auto-generated method stub

	// main method should not be called;
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("hello im from home url"); // printed in console
		model.addAttribute("name", "Saurabh Maurya");

		List<String> friends = new ArrayList<String>();
		friends.add("saurabh");
		friends.add("yash");
		friends.add("vikas");

		// same as before;

		model.addAttribute("f", friends); // and get this in index.jsp
		return "index"; // index.jsp runs
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/help")

//	With Model
//	public String help() {
//		
//		System.out.println("Hey!!!! ..... I'm from help.jsp");
//		return "help";
//	}

	// With ModelAndView
	public ModelAndView help() {
		System.out.println("Hey!!!! ..... I'm from modelAndView");

		// creating the ModelAndView ;
		ModelAndView obj = new ModelAndView();

		// setting the data ;
		obj.addObject("name", "uttam");

		// adding list ;

		List<Integer> list = new ArrayList<Integer>();
		list.add(63);
		list.add(92);
		list.add(27);
		list.add(27);
		list.add(16);

		obj.addObject("marks", list); // passing marks as key by which we are getting list

		// setting the view name;
		obj.setViewName("help");

		return obj;
	}
}
