package com.stc.stc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stc.stc.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
    
//    @Query("SELECT SUM(e.tasks) FROM User e")
//  @Query(value = "SELECT SUM(tasks_numbers) FROM users", nativeQuery = true)
//    Long sumTasks(); 
}
