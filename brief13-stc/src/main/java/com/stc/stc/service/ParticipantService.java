package com.stc.stc.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.dto.ParticipantDto;
import com.stc.stc.entity.Participant;
import com.stc.stc.exception.ResourceNotFoundException;
import com.stc.stc.repository.ParticipantRepository;
import com.stc.stc.response.ParticipantResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

	private ParticipantRepository participantRepository;

	private ModelMapper mapper;

	public ParticipantService(ParticipantRepository participantRepository, ModelMapper mapper) {
		this.participantRepository = participantRepository;
		this.mapper = mapper;
	}

	public ParticipantResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Participant> participants;
		participants = participantRepository.findAll(pageable);
		List<Participant> listOfParticipants = participants.getContent();
		List<ParticipantDto> participantContent = listOfParticipants.stream().map(participant -> mapToDTO(participant)).collect(Collectors.toList());
		ParticipantResponse participantResponse = new ParticipantResponse();
		participantResponse.setContent(participantContent);
		participantResponse.setPageNo(participants.getNumber());
		participantResponse.setPageSize(participants.getSize());
		participantResponse.setTotalElements(participants.getTotalElements());
		participantResponse.setTotalPages(participants.getTotalPages());
		participantResponse.setLast(participants.isLast());
		return participantResponse;
	}

	public ParticipantDto getOne(long id) {
		Participant participant = participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
		return mapToDTO(participant);
	}

	public ParticipantDto create(ParticipantDto participantDto) {
		Participant participant = mapToEntity(participantDto);
		Participant newParticipant = participantRepository.save(participant);
		ParticipantDto participantResponse = mapToDTO(newParticipant);
		return participantResponse;
	}

	public ParticipantDto update(ParticipantDto participantDto, long id) {
		Participant participant = participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
		participant.setDomain(participantDto.getDomain());
		Participant updatedParticipant = participantRepository.save(participant);
		return mapToDTO(updatedParticipant);
	}

	public void delete(long id) {
		Participant participant = participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Participant", "id", id));
		participantRepository.delete(participant);
	}

	private ParticipantDto mapToDTO(Participant participant) {
		ParticipantDto participantDto = mapper.map(participant, ParticipantDto.class);
		return participantDto;
	}

	private Participant mapToEntity(ParticipantDto participantDto) {
		Participant participant = mapper.map(participantDto, Participant.class);
		return participant;
	}

}
