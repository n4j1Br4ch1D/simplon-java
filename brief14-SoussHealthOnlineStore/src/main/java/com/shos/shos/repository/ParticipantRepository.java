package com.shos.shos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shos.shos.entity.Participant;




public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
}
