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

import com.stc.stc.entity.Activity;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.ActivityRepository;

 
@Service
public class ActivityService implements ServiceInterface<Activity> {
     
    @Autowired
    ActivityRepository activityRepository;
     
    public List<Activity> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Activity> pagedResult = activityRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Activity>();
        }
    }
    
	@Override
    public Activity getOne(Long id) throws RecordNotFoundException
    {
        Optional<Activity> activity = activityRepository.findById(id);
         
        if(activity.isPresent()) {
            return activity.get();
        } else {
            throw new RecordNotFoundException("No activity record exist for given id");
        }
         
        
    }
    
	@Override 
    public Activity save(Activity entity) throws RecordNotFoundException
    {
        Optional<Activity> activity = activityRepository.findById(entity.getId());
         
        if(activity.isPresent())
        {
            Activity newEntity = activity.get();
//            newEntity.setEmail(entity.getEmail());
//            newEntity.setFullName(entity.getFullName()); 
            newEntity = activityRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = activityRepository.save(entity);
             
            return entity;
        }
    }
     
    
	@Override
    public void delete(Long id) throws RecordNotFoundException
    {
        Optional<Activity> activity = activityRepository.findById(id);
         
        if(activity.isPresent())
        {
        	activityRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No activity record exist for given id");
        }
    }

}