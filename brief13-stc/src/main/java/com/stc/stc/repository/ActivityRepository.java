package com.stc.stc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stc.stc.entity.Activity;




public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
}
