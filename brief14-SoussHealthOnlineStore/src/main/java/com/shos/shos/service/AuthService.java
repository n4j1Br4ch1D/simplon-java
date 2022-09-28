package com.shos.shos.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shos.shos.entity.Permission;
import com.shos.shos.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService implements UserDetailsService {

    final UserRepository userRepository;
    protected Optional<com.shos.shos.entity.User> user;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.shos.shos.entity.User> user = userRepository.findByUserNameOrEmail(userName, userName);
        this.user = user;
       List<GrantedAuthority> authorityList = new  ArrayList<>();

  
//        authorityList.add(
//        		new SimpleGrantedAuthorit(user.getPermissions())
//        		);
//        
        authorityList =  mapRolesToAuthorities(user.get().getPermissions());
        User authUser = new User(user.get().getUserName(), user.get().getPassword(), authorityList);

        return authUser;

    }
    
    
    public Map<String, Object> authUser(String userName){
        Map<String, Object> mapUser = new HashMap<String, Object>();
        mapUser.put("authUser", this.loadUserByUsername(userName));
        mapUser.put("user", this.user);
        return mapUser;
    }

    
    public UserDetails createUserDetails(String userName, String password) {
        Optional<com.shos.shos.entity.User> user = userRepository.findByUserNameOrEmail(userName, userName);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("participant"));
        User nuser = new User(userName, password, authorityList);
        return nuser;

    }
    
    
    
    
    private List<GrantedAuthority> mapRolesToAuthorities(Collection<Permission> collection){
        return collection.stream().map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());
    }

}
