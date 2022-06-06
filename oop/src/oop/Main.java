package oop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	    System.out.println("\r\n"                       
    			+ "   __      /\\ ________              .__                               __   \r\n"
    			+ "  / /     / / \\______ \\   _______  _|  |   ____ ______   ___________  \\ \\  \r\n"
    			+ " / /     / /   |    |  \\_/ __ \\  \\/ /  |  /  _ \\\\____ \\_/ __ \\_  __ \\  \\ \\ \r\n"
    			+ " \\ \\    / /    |    `   \\  ___/\\   /|  |_(  <_> )  |_> >  ___/|  | \\/  / / \r\n"
    			+ "  \\_\\  / /    /_______  /\\___  >\\_/ |____/\\____/|   __/ \\___  >__|    /_/  \r\n"
    			+ "       \\/             \\/     \\/                 |__|        \\/             \r\n"
    			+ "       ===========> Developed By SoussTalents101 Group 1 <===========                          \r\n"
    			+ ""); 	
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter your Name: ");
		String name = reader.nextLine();
		System.out.println("Enter your Age: ");
		int age = reader.nextInt();
		System.out.println("Enter your Salary: ");
		double salary = reader.nextDouble();
		JavaDeveloper developerObj = new JavaDeveloper(name, age);
		developerObj.setSalary(salary);
		
		Developer.info();
		developerObj.code();
	}

}

class Developer{ 
	
	final static String  DEPARTMENT = "Development Web & Mobile";
	static public String developerName;
	static public int developerAge;
	static private double developerSalary;

	
	public Developer(String name, int age) {
		developerName = name;
		developerAge = age;
	}	
	
    public static double getSalary() {
		return developerSalary;
	}
	public void setSalary(double salary) {
		developerSalary = salary;
	}
	
    void code(){System.out.println("Coding In C++ ...");}  
    static void info(){

    System.out.println("Depatment: " + DEPARTMENT); 	
    System.out.println("Developer Name: " + developerName); 	
    System.out.println("Developer Age: " + developerAge);
    System.out.println("Developer Salary: " + getSalary() + "DH");

    System.out.println(); 	

    }
}  


class JavaDeveloper extends Developer {

    public JavaDeveloper(String name, int age) {
		super(name, age);
	}
 
	void code(){System.out.println("Coding In JAVA ...");} 

}