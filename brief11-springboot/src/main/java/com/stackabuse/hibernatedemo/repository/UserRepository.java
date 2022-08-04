package com.stackabuse.hibernatedemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stackabuse.hibernatedemo.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
//    public List<User> listEmployees(String role);
    List<User> findByRole(String role);
    
    @Query("SELECT SUM(e.tasks) FROM User e")
//  @Query(value = "SELECT SUM(total_days) FROM MyEntity", nativeQuery = true)
    Long sumTasks();
    

}
