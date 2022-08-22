package com.stc.stc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.entity.User;
import com.stc.stc.repository.UserRepository;



@Service
public class UserService implements ServiceInterface <User>{

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User getOne(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		return user;
	}
	
	
	@Override
	public void save(User user) {
		this.userRepository.save(user);
	}


	@Override
	public void delete(long id) {
		this.userRepository.deleteById(id);
	}
	
	
	public List<User> getAllEmployees() {
		return userRepository.findByRole("employee");
	}
}
