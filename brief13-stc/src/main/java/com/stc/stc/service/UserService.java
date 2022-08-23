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

import com.stc.stc.entity.User;
import com.stc.stc.exception.RecordNotFoundException;
import com.stc.stc.repository.UserRepository;

 
@Service
public class UserService implements ServiceInterface<User> {
     
    @Autowired
    UserRepository userRepository;
     
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<User> pagedResult = userRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }

	@Override
	public User getOne(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User obj) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}
     
    


//    public User getOne(Long id) throws RecordNotFoundException
//    {
//        Optional<User> user = userRepository.findById(id);
//         
//        if(user.isPresent()) {
//            return user.get();
//        } else {
//            throw new RecordNotFoundException("No user record exist for given id");
//        }
//         
//        
//    }
//     
//    public User save(User entity) throws RecordNotFoundException
//    {
//        Optional<User> user = userRepository.findById(entity.getId());
//         
//        if(user.isPresent())
//        {
//            User newEntity = user.get();
//            newEntity.setEmail(entity.getEmail());
//            newEntity.setFullName(entity.getFullName()); 
//            newEntity = userRepository.save(newEntity);
//             
//            return newEntity;
//        } else {
//            entity = userRepository.save(entity);
//             
//            return entity;
//        }
//    }
//     
//    public void delete(Long id) throws RecordNotFoundException
//    {
//        Optional<User> user = userRepository.findById(id);
//         
//        if(user.isPresent())
//        {
//        	userRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException("No user record exist for given id");
//        }
//    }

}