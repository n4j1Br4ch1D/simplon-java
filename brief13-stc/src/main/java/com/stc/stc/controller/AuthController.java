package com.stc.stc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
	public class AuthController {

	    @GetMapping("/signin")
	    public String showLoginForm(Model model) throws Exception {
//          List<Department> findOneByDepartmentName(String name);
            // User admin = userService.getAdmin();
			// model.addAttribute("email", admin.getEmail());
			// model.addAttribute("password", admin.getPassword());

			model.addAttribute("email", "leila@anmoon.ma");
			model.addAttribute("password", "password");
	        return "signin";
	    }
	    

	}


