package com.aopexample;
import com.aopexample.service.MathService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopBeforeAfterSpringBootTest
{
	@Autowired
	private MathService mathService;

	
	@Test
	public void testGetEmployeeById() {
		mathService.add2Num(99, 100);
	}
}