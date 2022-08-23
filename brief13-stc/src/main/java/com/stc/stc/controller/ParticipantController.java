package com.stc.stc.controller;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stc.stc.entity.Participant;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@GetMapping
	public ResponseEntity<List<Participant>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		List<Participant> list = participantService.getAll(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Participant>>(list, HttpStatus.OK);
	}

    
	@GetMapping("/{id}")
	public ResponseEntity<Participant> getParticipantById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Participant entity = participantService.getOne(id);
		System.out.println(entity.getFullName());
		return new ResponseEntity<Participant>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Participant> createOrUpdateParticipant(Participant participant) throws RecordNotFoundException {
		Participant updated = participantService.save(participant);
		return new ResponseEntity<Participant>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteParticipantById(@PathVariable("id") Long id) throws RecordNotFoundException {
		participantService.delete(id);
		return HttpStatus.FORBIDDEN;
	}

}
