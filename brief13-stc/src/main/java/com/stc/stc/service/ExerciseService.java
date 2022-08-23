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

import com.stc.stc.entity.Exercise;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.ExerciseRepository;

 
@Service
public class ExerciseService implements ServiceInterface<Exercise> {
     
    @Autowired
    ExerciseRepository exerciseRepository;
     
    public List<Exercise> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Exercise> pagedResult = exerciseRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Exercise>();
        }
    }
    
	@Override
    public Exercise getOne(Long id) throws RecordNotFoundException
    {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
         
        if(exercise.isPresent()) {
            return exercise.get();
        } else {
            throw new RecordNotFoundException("No exercise record exist for given id");
        }
         
        
    }
    
	@Override 
    public Exercise save(Exercise entity) throws RecordNotFoundException
    {
        Optional<Exercise> exercise = exerciseRepository.findById(entity.getId());
         
        if(exercise.isPresent())
        {
            Exercise newEntity = exercise.get();
//            newEntity.setEmail(entity.getEmail());
//            newEntity.setFullName(entity.getFullName()); 
            newEntity = exerciseRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = exerciseRepository.save(entity);
             
            return entity;
        }
    }
     
    
	@Override
    public void delete(Long id) throws RecordNotFoundException
    {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
         
        if(exercise.isPresent())
        {
        	exerciseRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No exercise record exist for given id");
        }
    }

}