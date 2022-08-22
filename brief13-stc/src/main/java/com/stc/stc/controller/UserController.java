package com.stc.stc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.User;
import com.stc.stc.service.UserService;




@RestController
@RequestMapping("/dashboard")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users") // List Only Employees
	public List<User> getAllUsers(Model model) {
		return userService.getAll();
	}
	
	@GetMapping("/users/view/{id}") // Read
	public String viewUserById(Model model, @PathVariable(value = "id") Long userId) throws Exception {
		model.addAttribute("user", userService.getOne(userId));
		model.addAttribute("type", "Read");
		return "form";
	}

	@GetMapping("/users/new") // Create
	public String addUser(Model model) {
//		model.addAttribute("user", null);
		model.addAttribute("type", "Create");
		return "form";
	}

	@PostMapping("/users") // Insert
	public String saveUser(HttpServletRequest request, @ModelAttribute("user") User user) {
//        user.setFullName(request.getParameter("firstname")+" "+request.getParameter("lastname"));
		userService.save(user);
		return "redirect:/dashboard/users";
	}

	@GetMapping("/users/{id}") // Edit
	public String getUserById(Model model, @PathVariable(value = "id") Long userId) throws Exception {
//		model.addAttribute("user", userService.getUserById(userId));
		model.addAttribute("type", "Update");
		return "form";
	}

	@PutMapping("/users") // Update
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") User user) {
//        user.setFullName(request.getParameter("firstname")+" "+request.getParameter("lastname"));
		userService.save(user);
		return "redirect:/dashboard/users";
	}

	@DeleteMapping("/users/{id}") // Delete
	public String deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		this.userService.delete(userId);
		return "";
		
		
	}
}
