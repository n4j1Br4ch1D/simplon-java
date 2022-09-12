package com.shos.shos.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shos.shos.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
//  @Query(value = "{userName:'?0'}")
  User findUserByUserName(String userName);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String username, String email);
//    Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
//    Optional<Role> findByName(String name);

//	Page<User> findAll(Pageable pageRequest);

//	  Page<User> findByFullname(String fullname, Pageable pageable);

    List<User> findByRole(String role);
//    List<User> findAllByRole(double role, Pageable pageable);
    
	Page<User> findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);
	Page<User> findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(String role, Boolean isMale, Boolean enabled, Pageable pageable);

    
//    @Query("SELECT SUM(e.tasks) FROM User e")
//  @Query(value = "SELECT SUM(tasks_numbers) FROM users", nativeQuery = true)
//    Long sumTasks(); 
}
