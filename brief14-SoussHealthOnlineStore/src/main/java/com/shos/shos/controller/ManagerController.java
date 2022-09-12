package com.shos.shos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.shos.shos.config.AppConstants;
import com.shos.shos.dto.ManagerDto;
import com.shos.shos.response.ManagerResponse;
import com.shos.shos.service.ManagerService;

@RestController
@RequestMapping("/api/managers")
@Validated
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@GetMapping
	public ManagerResponse getAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return managerService.getAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ManagerDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(managerService.getOne(id));
	}

	@PostMapping
	public ResponseEntity<ManagerDto> create(@Valid @RequestBody ManagerDto managerDto) {
		return new ResponseEntity<>(managerService.create(managerDto), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ManagerDto> update(@Valid @RequestBody ManagerDto managerDto, @PathVariable(name = "id") long id) {
		ManagerDto managerResponse = managerService.update(managerDto, id);
		return new ResponseEntity<>(managerResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		managerService.delete(id);
		return new ResponseEntity<>("Manager entity deleted successfully.", HttpStatus.OK);
	}
}
