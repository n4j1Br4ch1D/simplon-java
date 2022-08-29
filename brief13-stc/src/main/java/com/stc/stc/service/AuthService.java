package com.stc.stc.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stc.stc.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.stc.stc.entity.User user = userRepository.findUserByUserName(userName);
        List<GrantedAuthority> authorityList = new ArrayList<>();
  
        authorityList.add(
        		new SimpleGrantedAuthority(user.getRole())
        		);
        User nuser = new User(user.getUserName(), user.getPassword(), authorityList);
        return nuser;
    }

    
    public UserDetails createUserDetails(String userName, String password) {
        com.stc.stc.entity.User user = userRepository.findUserByUserName(userName);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("participant"));
        User nuser = new User(userName, password, authorityList);
        return nuser;

    }

}
