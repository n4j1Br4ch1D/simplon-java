package com.stackabuse.hibernatedemo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stackabuse.hibernatedemo.entity.User;



public interface UserService {
	List<User> getAllUsers();
	List<User> getAllEmployees();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUserById(long id);
	Long tasksSum();
}
