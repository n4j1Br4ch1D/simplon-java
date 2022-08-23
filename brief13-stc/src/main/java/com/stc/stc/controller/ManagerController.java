package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Manager;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.ManagerService;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@GetMapping
	public ResponseEntity<List<Manager>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<Manager> list = managerService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Manager>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<Manager> getManagerById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Manager entity = managerService.getOne(id);
		System.out.println(entity.getFullName());
		return new ResponseEntity<Manager>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Manager> createOrUpdateManager(Manager manager) throws RecordNotFoundException {
		Manager updated = managerService.save(manager);
		return new ResponseEntity<Manager>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteManagerById(@PathVariable("id") Long id) throws RecordNotFoundException {
		managerService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
