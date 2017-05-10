package com.rit.enrollment.controllers;


import java.util.Locale;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rit.enrollment.logic.UserService;
import com.rit.enrollment.repository.User;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	   
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "main";
	}
	
	
	 @RequestMapping(value = "/xx", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout,@ModelAttribute("SpringWeb") User user) {
		 System.out.println("user.getNickname()" + user.getUsername());
		 System.out.println("user.getPassword()" + user.getPassword());
			try{
				if (user== null || user.getUsername() == "" || user.getPassword() == ""){
					model.addAttribute("error", "Enter username and password");
					 return "login";
				}
					
		 User userLogued = new User(null);//userService.validateUser(user.getUsername(), user.getPassword());
		 System.out.println(userLogued);
		  model.addAttribute("username",  user.getUsername());
		  return "main";
			} catch (NoResultException ex){
			System.out.println(ex);
			 model.addAttribute("error", "Your username and password is invalid.");
			 return "login";
			}
	    }
	
}
