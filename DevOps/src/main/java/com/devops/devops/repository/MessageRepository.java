package com.devops.devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.devops.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {}
