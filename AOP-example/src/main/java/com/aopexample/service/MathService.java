package com.aopexample.service;

import org.springframework.stereotype.Service;

@Service
public class MathService
{
	public void add2Num(Integer a, Integer b)
	{  
		//Before
		Integer c = a+b;
		System.out.println("\n\nAdding Two Numbers "+a+"+"+b+" = "+c+"\n\n");
		System.out.println("\n\nShowing Result "+c+"\n\n");
		//After
    }
	
}
