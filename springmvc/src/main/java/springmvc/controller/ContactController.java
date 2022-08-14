package springmvc.controller;

import springmvc.model.User;
import springmvc.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void commondata(Model newobj) {
		newobj.addAttribute("key1", "Hello I'm Executed");
	}

	@RequestMapping("/contact")
	public String show() {
		System.out.println("Im from control");
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)

	/*
	 * // from old method as before in jsp public String
	 * handlerForm(HttpServletRequest request) { String name =
	 * request.getParameter("name"); System.out.println(name);
	 * 
	 * return ""; }
	 */

//	We are using in spring mvc Requestparam annotation 

	/*
	 * 
	 * public String handlerForm(@RequestParam(name = "email", required = false)
	 * String useremail,
	 * 
	 * @RequestParam("name") String username, @RequestParam("pass") String userpass,
	 * Model obj) { // System.out.println(useremail + " " + username + " " +
	 * userpass); // check in // console.
	 * 
	 * User user = new User(); user.setEmail(useremail); user.setPass(userpass);
	 * user.setName(username);
	 * 
	 * // fetch into jsp page; // obj.addAttribute("name", username); //
	 * obj.addAttribute("email", useremail); // obj.addAttribute("pass", userpass);
	 * 
	 * // now we are adding the whole obj of user obj.addAttribute("userkey", user);
	 * 
	 * return "success"; }
	 * 
	 */

	// by using @ModelAttribute

	public String handlerForm(@ModelAttribute User user, Model model) {
		System.out.println(user);
		if (user.getName().isBlank() == true) {
			return "redirect:/contact";
		}
		int id = this.userService.createUser(user);
		model.addAttribute("msg", "user created with id" + id);
		return "success";
	}

}
