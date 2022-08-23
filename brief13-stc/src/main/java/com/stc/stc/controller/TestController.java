package com.stc.stc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Manager;
import com.stc.stc.entity.User;
import com.stc.stc.repository.ManagerRepository;
import com.stc.stc.service.UserService;




@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private ManagerRepository managerRepository;

	@GetMapping("/managers") // List Only Employees
	public List<Manager> getAllPersons(Model model) {
		System.out.println("hhhhhhhh");
	    System.out.println(managerRepository.findAll());
		return  managerRepository.findAll();
	}
}
