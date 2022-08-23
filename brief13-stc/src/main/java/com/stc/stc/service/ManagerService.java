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

import com.stc.stc.entity.Manager;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.ManagerRepository;

 
@Service
public class ManagerService implements ServiceInterface<Manager> {
     
    @Autowired
    ManagerRepository managerRepository;
     
    public List<Manager> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Manager> pagedResult = managerRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Manager>();
        }
    }
    
	@Override
    public Manager getOne(Long id) throws RecordNotFoundException
    {
        Optional<Manager> manager = managerRepository.findById(id);
         
        if(manager.isPresent()) {
            return manager.get();
        } else {
            throw new RecordNotFoundException("No manager record exist for given id");
        }
         
        
    }
    
	@Override 
    public Manager save(Manager entity) throws RecordNotFoundException
    {
        Optional<Manager> manager = managerRepository.findById(entity.getId());
         
        if(manager.isPresent())
        {
            Manager newEntity = manager.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFullName(entity.getFullName()); 
            newEntity = managerRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = managerRepository.save(entity);
             
            return entity;
        }
    }
     
    
	@Override
    public void delete(Long id) throws RecordNotFoundException
    {
        Optional<Manager> manager = managerRepository.findById(id);
         
        if(manager.isPresent())
        {
        	managerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No manager record exist for given id");
        }
    }

}