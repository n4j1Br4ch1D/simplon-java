package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Admin;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public ResponseEntity<List<Admin>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<Admin> list = adminService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Admin entity = adminService.getOne(id);
		System.out.println(entity.getFullName());
		return new ResponseEntity<Admin>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Admin> createOrUpdateAdmin(Admin admin) throws RecordNotFoundException {
		Admin updated = adminService.save(admin);
		return new ResponseEntity<Admin>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteAdminById(@PathVariable("id") Long id) throws RecordNotFoundException {
		adminService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
