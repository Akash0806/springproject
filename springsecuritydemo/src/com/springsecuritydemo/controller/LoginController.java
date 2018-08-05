package com.springsecuritydemo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springsecuritydemo.model.User;
import com.springsecuritydemo.services.UserServices;



@Controller
public class LoginController {
	
	@Autowired
	UserServices userServices;
	
	private LoginController(){
		System.out.println("Login controller");
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
	 
	 @RequestMapping(value="/welcome",method=RequestMethod.GET)
	 public String printWelcome(Principal principal,Model modelMap){
		 return "welcome"; 
	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
	        //userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }
            userServices.save(userForm);
            
        return "redirect:/welcome";
	    }

	 
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new com.springsecuritydemo.model.User());

	        return "registration";
	    }


}
