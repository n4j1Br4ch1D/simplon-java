package com.shos.shos.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shos.shos.entity.User;
import com.shos.shos.enums.Role;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String username, String email);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    List<User> findAllByRole(Role role, Pageable pageable);
	Page<User> findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);
	Page<User> findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);
}
