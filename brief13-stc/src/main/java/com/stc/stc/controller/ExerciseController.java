package com.stc.stc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.config.AppConstants;
import com.stc.stc.dto.ExerciseDto;
import com.stc.stc.response.ExerciseResponse;
import com.stc.stc.service.ExerciseService;

@RestController
@RequestMapping("/api/exercises")
@Validated
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	@GetMapping
	public ExerciseResponse getAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return exerciseService.getAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ExerciseDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(exerciseService.getOne(id));
	}

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@PostMapping
	public ResponseEntity<ExerciseDto> create(@Valid @RequestBody ExerciseDto exerciseDto) {
		return new ResponseEntity<>(exerciseService.create(exerciseDto), HttpStatus.CREATED);
	}

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	@PutMapping("/{id}")
	public ResponseEntity<ExerciseDto> update(@Valid @RequestBody ExerciseDto exerciseDto, @PathVariable(name = "id") long id) {
		ExerciseDto exerciseResponse = exerciseService.update(exerciseDto, id);
		return new ResponseEntity<>(exerciseResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		exerciseService.delete(id);
		return new ResponseEntity<>("Exercise entity deleted successfully.", HttpStatus.OK);
	}
}
