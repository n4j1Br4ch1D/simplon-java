package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Exercise;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.ExerciseService;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;

	@GetMapping
	public ResponseEntity<List<Exercise>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<Exercise> list = exerciseService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<Exercise> getExerciseById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Exercise entity = exerciseService.getOne(id);
		return new ResponseEntity<Exercise>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Exercise> createOrUpdateExercise(Exercise exercise) throws RecordNotFoundException {
		Exercise updated = exerciseService.save(exercise);
		return new ResponseEntity<Exercise>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteExerciseById(@PathVariable("id") Long id) throws RecordNotFoundException {
		exerciseService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
