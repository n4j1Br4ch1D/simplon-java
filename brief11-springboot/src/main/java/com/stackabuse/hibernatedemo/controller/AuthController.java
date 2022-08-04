package com.stackabuse.hibernatedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
	public class AuthController {

	    @GetMapping("/signin")
	    public String showLoginForm(Model model) throws Exception {
//			model.addAttribute("user", userService.getUserById(userId));
//			model.addAttribute("type", "Read");
//			model.addAttribute("SigninError", error);
			model.addAttribute("email", "leila@anmoon.ma");
			model.addAttribute("password", "password");
	        return "signin";
	    }
	    

	}


