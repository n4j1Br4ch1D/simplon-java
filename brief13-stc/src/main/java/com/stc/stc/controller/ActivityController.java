package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Activity;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@GetMapping
	public ResponseEntity<List<Activity>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<Activity> list = activityService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Activity>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Activity entity = activityService.getOne(id);
		return new ResponseEntity<Activity>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Activity> createOrUpdateActivity(Activity activity) throws RecordNotFoundException {
		Activity updated = activityService.save(activity);
		return new ResponseEntity<Activity>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteActivityById(@PathVariable("id") Long id) throws RecordNotFoundException {
		activityService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
