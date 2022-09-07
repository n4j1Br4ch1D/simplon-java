package com.devops.devops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.devops.entity.Message;
import com.devops.devops.repository.MessageRepository;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	@Autowired
    private MessageRepository messageRepository;
	
    @GetMapping("/test")
    public String getMessage() {
        return "Docker Says Hello World by Springboot!";
    }
    
    @GetMapping
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }
    

}