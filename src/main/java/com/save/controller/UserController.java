package com.save.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.save.model.User;
import com.save.service.ISecurityService;
import com.save.service.IUserService;
import com.save.validator.UserValidator;

@Controller
@RequestMapping("/")
public class UserController {
	
	//logger
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String registration(Model model) {
		log.info("methode GET pour registration");
		model.addAttribute("userForm", new User());
		
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		
		userValidator.validate(userForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(userForm);
		
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		
		return "redirect:/home";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if(error !=null)
			model.addAttribute("error", "Your username and password is invalid");
		
		if(logout != null)
			model.addAttribute("message","You have been logged out successfully");
		
		return "login";
	}
	
	@RequestMapping(value= {"/","/home"}, method=RequestMethod.GET)
	public String welcome(Model model) {
		return "home";
	}

}
