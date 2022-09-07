package com.devops.devops;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devops.devops.controller.MessageController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private MessageController messageController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(messageController).isNotNull();
	}
}