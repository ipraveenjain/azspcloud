package pbj.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pbj.springmvc.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
		System.out.println("in login ");
		boolean isValidUser = service.validateUser(name);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(ModelMap model, @RequestParam String name, @RequestParam String password){
		System.out.println("in register ");
		boolean isValidUser = service.register(name,password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Unable to register");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "register";
	}

}
