package com.stc.stc.repository;


import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.stc.stc.entity.User;



public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByRole(String role);
//    List<User> findAllByRole(double role, Pageable pageable);

    
//    @Query("SELECT SUM(e.tasks) FROM User e")
//  @Query(value = "SELECT SUM(tasks_numbers) FROM users", nativeQuery = true)
//    Long sumTasks(); 
}
