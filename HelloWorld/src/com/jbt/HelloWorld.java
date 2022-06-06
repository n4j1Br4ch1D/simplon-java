package com.jbt;
import java.text.DecimalFormat;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("Hello World, SIMPLON is HERE!");
	    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
	    
	    System.out.println("my Favorit Car is: "+cars[0]);
	    
	    
		System.out.println("\r\n"
				+ "   _____            __    _____     __         __\r\n"
				+ "  / __(_)_ _  ___  / /__ / ___/__ _/ /_____ __/ /\r\n"
				+ " _\\ \\/ /  ' \\/ _ \\/ / -_) /__/ _ `/ / __/ // / / \r\n"
				+ "/___/_/_/_/_/ .__/_/\\__/\\___/\\_,_/_/\\__/\\_,_/_/  \r\n"
				+ "           /_/                                   \r\n"
				+ "");
		
        Scanner reader = new Scanner(System.in);
        
        char operationType;
        double n1, n2, result = 0;

        System.out.print("Enter first number: ");

         n1 = reader.nextDouble();
         
 
       System.out.print("Enter second number: ");

         n2 = reader.nextDouble();
 
         System.out.print("Enter type  the operation: ");
         operationType = reader.next().charAt(0);

            switch (operationType) {

              case '+':
                result = n1 + n2;
                break;

              case '-':
                result = n1 - n2;
                break;

              case '*':
                result = n1 * n2;
                break;

              case '/':
            	  if(n2==0) {
            		  System.out.println("we cant devide by zero!");  
                      reader.close();
            		  return;
            	  }
                result = n1 / n2;
                break;

              default:
                System.out.println("error operation type!");
                break;
            }

            reader.close();
          
           DecimalFormat df = new DecimalFormat("###.#");
           System.out.println(df.format(result));

	}

}
