package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.User;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<User> list = userService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		User entity = userService.getOne(id);
		System.out.println(entity.getFullName());
		return new ResponseEntity<User>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createOrUpdateUser(User user) throws RecordNotFoundException {
		User updated = userService.save(user);
		return new ResponseEntity<User>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		userService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
