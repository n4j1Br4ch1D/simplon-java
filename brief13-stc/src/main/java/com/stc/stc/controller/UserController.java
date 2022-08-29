package com.stc.stc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.config.AppConstants;
import com.stc.stc.dto.UserDto;
import com.stc.stc.response.UserResponse;
import com.stc.stc.service.UserService;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public UserResponse getAll(@RequestParam(required = false) String filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return userService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(userService.getOne(id));
	}

	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userDto, @PathVariable(name = "id") long id) {
		UserDto userResponse = userService.update(userDto, id);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		userService.delete(id);
		return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
	}
}
