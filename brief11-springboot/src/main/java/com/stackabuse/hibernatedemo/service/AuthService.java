package com.stackabuse.hibernatedemo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackabuse.hibernatedemo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

}