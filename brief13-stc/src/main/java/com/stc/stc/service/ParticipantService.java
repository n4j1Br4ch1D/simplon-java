package com.stc.stc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.entity.Participant;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.ParticipantRepository;

 
@Service
public class ParticipantService implements ServiceInterface<Participant> {
     
    @Autowired
    ParticipantRepository participantRepository;
     
    public List<Participant> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Participant> pagedResult = participantRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Participant>();
        }
    }
    
	@Override
    public Participant getOne(Long id) throws RecordNotFoundException
    {
        Optional<Participant> participant = participantRepository.findById(id);
         
        if(participant.isPresent()) {
            return participant.get();
        } else {
            throw new RecordNotFoundException("No participant record exist for given id");
        }
         
        
    }
    
	@Override 
    public Participant save(Participant entity) throws RecordNotFoundException
    {
        Optional<Participant> participant = participantRepository.findById(entity.getId());
         
        if(participant.isPresent())
        {
            Participant newEntity = participant.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFullName(entity.getFullName()); 
            newEntity = participantRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = participantRepository.save(entity);
             
            return entity;
        }
    }
     
    
	@Override
    public void delete(Long id) throws RecordNotFoundException
    {
        Optional<Participant> participant = participantRepository.findById(id);
         
        if(participant.isPresent())
        {
        	participantRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No participant record exist for given id");
        }
    }

}