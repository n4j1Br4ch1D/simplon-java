package com.shos.shos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shos.shos.entity.Exercise;




public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	
}
