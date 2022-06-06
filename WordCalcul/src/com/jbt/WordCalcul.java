package com.jbt;
import java.util.Scanner;

public class WordCalcul {
	
	
	static int countNumWords(String str, String word)
	{
	    String a[] = str.split(" ");
	    int count = 0;
	    for (int i = 0; i < a.length; i++)
	    {
	    if (word.equals(a[i]))
	        count++;
	    }
	 
	    return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\r\n"
				+ " __    __              _   ___      _            _ \r\n"
				+ "/ / /\\ \\ \\___  _ __ __| | / __\\__ _| | ___ _   _| |\r\n"
				+ "\\ \\/  \\/ / _ \\| '__/ _` |/ /  / _` | |/ __| | | | |\r\n"
				+ " \\  /\\  / (_) | | | (_| / /__| (_| | | (__| |_| | |\r\n"
				+ "  \\/  \\/ \\___/|_|  \\__,_\\____/\\__,_|_|\\___|\\__,_|_|\r\n"
				+ "                                                   \r\n"
				+ "");
		System.out.println("PLZ! Select number of operation:");
		System.out.println("1-Count Number of Chars.");
		System.out.println("2-Count Number of Words Occurence.");

        Scanner reader = new Scanner(System.in);
        char operationType = 0;
        String input = "", word= "";
    
        
        System.out.print("Enter type  the operation: ");
        operationType = reader.next().charAt(0);

        
        if(operationType=='1') {
            System.out.print("Enter your Sentence: ");
            input = reader.next();
    		System.out.println("Number of chars is: "+input.length());
        	
        }else if(operationType=='2'){
            System.out.print("Enter your Sentence: ");
            input = reader.next();
            System.out.print("Enter your Word: ");
            word = reader.next();
    		System.out.println("Word "++" is mentioned: "+countNumWords(str, word));
        }
        else {
    		System.out.println("Error opertaion doesnt exist!");

        }
        reader.close();

	}

}
