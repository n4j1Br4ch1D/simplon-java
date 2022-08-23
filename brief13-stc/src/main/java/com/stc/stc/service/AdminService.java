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

import com.stc.stc.entity.Admin;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.AdminRepository;

 
@Service
public class AdminService implements ServiceInterface<Admin> {
     
    @Autowired
    AdminRepository adminRepository;
     
    public List<Admin> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Admin> pagedResult = adminRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Admin>();
        }
    }
    
	@Override
    public Admin getOne(Long id) throws RecordNotFoundException
    {
        Optional<Admin> admin = adminRepository.findById(id);
         
        if(admin.isPresent()) {
            return admin.get();
        } else {
            throw new RecordNotFoundException("No admin record exist for given id");
        }
         
        
    }
    
	@Override 
    public Admin save(Admin entity) throws RecordNotFoundException
    {
        Optional<Admin> admin = adminRepository.findById(entity.getId());
         
        if(admin.isPresent())
        {
            Admin newEntity = admin.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFullName(entity.getFullName()); 
            newEntity = adminRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = adminRepository.save(entity);
             
            return entity;
        }
    }
     
    
	@Override
    public void delete(Long id) throws RecordNotFoundException
    {
        Optional<Admin> admin = adminRepository.findById(id);
         
        if(admin.isPresent())
        {
        	adminRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No admin record exist for given id");
        }
    }

}