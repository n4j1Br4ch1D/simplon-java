package com.jbt;

import java.util.Scanner;

// every line of code must be inside the class. in Java naming conventions or in OOP in general class must be in Pascal Case
public class SquareRoot { 
	public static void main(String[] args) { // Main method is required and you will see it in every Java program:
		// TODO Auto-generated method stub
		
		System.out.println("\r\n"
				+ "   _____                            _____             _   \r\n"
				+ "  / ____|                          |  __ \\           | |  \r\n"
				+ " | (___   __ _ _   _  __ _ _ __ ___| |__) |___   ___ | |_ \r\n"
				+ "  \\___ \\ / _` | | | |/ _` | '__/ _ \\  _  // _ \\ / _ \\| __|\r\n"
				+ "  ____) | (_| | |_| | (_| | | |  __/ | \\ \\ (_) | (_) | |_ \r\n"
				+ " |_____/ \\__, |\\__,_|\\__,_|_|  \\___|_|  \\_\\___/ \\___/ \\__|\r\n"
				+ "            | |                                           \r\n"
				+ "            |_|                                           \r\n"
				+ "");
		
		
		
	     Scanner reader = new Scanner(System.in); //the  new keyword is used to create an instance of the class.
  	     double input, squareRoot;
           
           do{
        	    System.out.println("Enter your Number(positive): ");
                 input = reader.nextDouble();
                 
                if (input == 0) { 
        	    	 System.out.println("Exit!");
        	    	 reader.close(); //close
        	         break;
        	    }else if(input < 0){
            	    System.out.println(input+" is Not a Positive Number!\r\n");

        	    } else {
        	        squareRoot = Math.sqrt(input);
        	        System.out.println("The square root of " + input + " is " + squareRoot+"\r\n");
        	    }
        	} while(true); 
           

           reader.close();

	}
	

}
