package com.stc.stc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.config.AppConstants;
import com.stc.stc.dto.ActivityDto;
import com.stc.stc.response.ActivityResponse;
import com.stc.stc.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
@Validated
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}

	@GetMapping
	public ActivityResponse getAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return activityService.getAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ActivityDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(activityService.getOne(id));
	}

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@PostMapping
	public ResponseEntity<ActivityDto> create(@Valid @RequestBody ActivityDto activityDto) {
		return new ResponseEntity<>(activityService.create(activityDto), HttpStatus.CREATED);
	}

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@PutMapping("/{id}")
	public ResponseEntity<ActivityDto> update(@Valid @RequestBody ActivityDto activityDto, @PathVariable(name = "id") long id) {
		ActivityDto activityResponse = activityService.update(activityDto, id);
		return new ResponseEntity<>(activityResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		activityService.delete(id);
		return new ResponseEntity<>("Activity entity deleted successfully.", HttpStatus.OK);
	}
}
