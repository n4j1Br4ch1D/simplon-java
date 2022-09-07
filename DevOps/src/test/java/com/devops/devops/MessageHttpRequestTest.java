package com.devops.devops;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageHttpRequestTest {

	@SuppressWarnings("deprecation")
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	//Test /test Endpoint
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		//Arange
		String msgExpected = "Docker Says Hello World by Springboot!"; 
		//Act
		String msgAction = this.restTemplate.getForObject("http://localhost:" + port + "/api/messages/test", String.class); 
		//Assert
		assertEquals(msgExpected, msgAction);

	}
	
	
}