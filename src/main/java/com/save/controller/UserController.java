package com.save.controller;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.save.model.User;
import com.save.service.IEmailService;
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
	
	@Autowired
	private IEmailService emailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	//methode GET pour récuperer l'email de l'utilisateur
	@RequestMapping(value="/forgot", method=RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("forgotPassword");
	}
	
	//methode POST pour récuperer l'email de l'utilisateur
	@RequestMapping(value="/forgot", method=RequestMethod.POST)
	public ModelAndView passwordForgotPost(ModelAndView modelAndView, @RequestParam("email") String userEmail,
			HttpServletRequest request, Locale locale) {
		log.info("methode POST qui recupère l'adresse mail");
		
		//recherche de l'utilisateur dans la BD
		Optional<User> optional = userService.findUserByEmail(userEmail);
		
		if(!optional.isPresent()) {
			//i18n du message d'erreur
			String errorMessage = messageSource.getMessage("email.notFound",null, locale);
			modelAndView.addObject("errorMessage",errorMessage);
			
		} else {
				
			//génère un token aléatoire de 36 caractères
			User user = optional.get();
			user.setResetToken(UUID.randomUUID().toString());
			
			userService.save(user);
			
			//construit l'url du lien qui sera envoyé
			String appUrl = request.getScheme() + "://" + request.getServerName() +":"  + request.getLocalPort()
			+ request.getContextPath();
			
			//email
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("support@save.com");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Demande de réinitialisation du mot de passe");
			passwordResetEmail.setText("Pour réinitialiser votre mot de passe, cliquez sur le lien suivant:\n" + appUrl
					+ "/reset?token=" + user.getResetToken());
			
			emailService.sendEmail(passwordResetEmail);
			
			String successMessage = messageSource.getMessage("email.send", null, locale);
			modelAndView.addObject("successMessage", successMessage +" " + userEmail);
			
		}
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
		
	}
	
	//Display form to reset password
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		Optional<User> optional = userService.findUserByResetToken(token);
		
		if(optional.isPresent()) {
			modelAndView.addObject("resetToken", token);
		} else {
			modelAndView.addObject("errorMessage", "invalid password reset link");
		}
		
		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}
	
	//Process reset password form
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	public ModelAndView newPasswordPost(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams,
			 RedirectAttributes redir) {
		
		
		Optional<User> optional = userService.findUserByResetToken(requestParams.get("token"));
		
		if(optional.isPresent()) {
			User resetUser  = optional.get();
			log.info("password: " + requestParams.get("password"));
			resetUser.setPassword(requestParams.get("password"));
			
			resetUser.setResetToken(null);
			
			userService.save(resetUser);
			
			redir.addFlashAttribute("successMessage","Mot de passe réinitialisé. Vous pouvez vous loguer");
			
			modelAndView.setViewName("redirect:login");
			return modelAndView;
			
			
		} else {
			modelAndView.addObject("errorMessage", "Le lien est invalide");
			modelAndView.setViewName("resetPassword");
		}
		return modelAndView;
	}
	
	//Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
	

}
