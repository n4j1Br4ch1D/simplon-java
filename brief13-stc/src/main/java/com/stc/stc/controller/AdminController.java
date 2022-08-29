package com.stc.stc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.config.AppConstants;
import com.stc.stc.dto.AdminDto;
import com.stc.stc.response.AdminResponse;
import com.stc.stc.service.AdminService;

@RestController
@RequestMapping("/api/admins")
@Validated
public class AdminController {

	@Autowired
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping
	public AdminResponse getAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return adminService.getAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(adminService.getOne(id));
	}

	@PostMapping
	public ResponseEntity<AdminDto> create(@Valid @RequestBody AdminDto adminDto) {
		return new ResponseEntity<>(adminService.create(adminDto), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<AdminDto> update(@Valid @RequestBody AdminDto adminDto, @PathVariable(name = "id") long id) {
		AdminDto adminResponse = adminService.update(adminDto, id);
		return new ResponseEntity<>(adminResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		adminService.delete(id);
		return new ResponseEntity<>("Admin entity deleted successfully.", HttpStatus.OK);
	}
}
