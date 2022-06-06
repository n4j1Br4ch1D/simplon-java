package com.jbt;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalculAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\r\n"
				+ "  ___             _____   ___  _            _ \r\n"
				+ " / _ \\           /  __ \\ / _ \\| |          | |\r\n"
				+ "/ /_\\ \\ __ _  ___| /  \\// /_\\ \\ | ___ _   _| |\r\n"
				+ "|  _  |/ _` |/ _ \\ |    |  _  | |/ __| | | | |\r\n"
				+ "| | | | (_| |  __/ \\__/\\| | | | | (__| |_| | |\r\n"
				+ "\\_| |_/\\__, |\\___|\\____/\\_| |_/_|\\___|\\__,_|_|\r\n"
				+ "        __/ |                                 \r\n"
				+ "       |___/                                  \r\n"
				+ "");
		System.out.println("PLZ! Select number of operation:");
		System.out.println("1-calcul by Age.");
		System.out.println("2-clacul by DOF.");

        Scanner reader = new Scanner(System.in);
        char operationType = 0;
        int input = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        
        System.out.print("Enter type  the operation: ");
        operationType = reader.next().charAt(0);

        
        if(operationType=='1') {
            System.out.print("Enter your Age: ");
            input = reader.nextInt();
    		System.out.println("You are Born on: "+(year-input));

        	
        }else if(operationType=='2'){
            System.out.print("Enter your DOF: ");
            input = reader.nextInt();
    		System.out.println("Your Age is: "+(year-input));

        }
        else {
    		System.out.println("Error opertaion doesnt exist!");

        }
        reader.close();

	}

}
