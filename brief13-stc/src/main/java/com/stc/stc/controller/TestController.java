package com.stc.stc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.User;
import com.stc.stc.repository.ManagerRepository;
import com.stc.stc.service.UserService;




//@RestController
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private ManagerRepository managerRepository;

	@GetMapping("/persons") // List Only Employees
	public String getAllPersons(Model model) {
		System.out.println("hhhhhhhh");
	    System.out.println(managerRepository.findAll());
		return "test";
	}
}
