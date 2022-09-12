package com.shos.shos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.shos.shos.config.AppConstants;
import com.shos.shos.dto.ParticipantDto;
import com.shos.shos.response.ParticipantResponse;
import com.shos.shos.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
@Validated
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	public ParticipantController(ParticipantService participantService) {
		this.participantService = participantService;
	}

	@GetMapping
	public ParticipantResponse getAll(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return participantService.getAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ParticipantDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(participantService.getOne(id));
	}

	@PostMapping
	public ResponseEntity<ParticipantDto> create(@Valid @RequestBody ParticipantDto participantDto) {
		return new ResponseEntity<>(participantService.create(participantDto), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ParticipantDto> update(@Valid @RequestBody ParticipantDto participantDto, @PathVariable(name = "id") long id) {
		ParticipantDto participantResponse = participantService.update(participantDto, id);
		return new ResponseEntity<>(participantResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		participantService.delete(id);
		return new ResponseEntity<>("Participant entity deleted successfully.", HttpStatus.OK);
	}
}
