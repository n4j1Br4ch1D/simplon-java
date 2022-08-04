package com.stackabuse.hibernatedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
	public class AuthController {

	    @GetMapping("/signin")
	    public String showLoginForm(){
	        return "signin";
	    }

	}


