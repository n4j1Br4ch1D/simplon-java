import java.util.Scanner;

public class Amount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****** AmountCalculator ******");
		String name; 
        int hoursPerWeek, hoursPerMonth,overTime, result, hourRate, minHoursPerWeek = 40;
        char operationType;

	    Scanner reader = new Scanner(System.in); //the  new keyword is used to create an instance of the class.
		//A message that prompts the employee to enter their name
		  System.out.println("Enter your Name: ");
		  name = reader.next();
		// A welcome message on behalf of the user
		  System.out.println("Hi there, "+name+"!");
   
       do {
		System.out.println("Choose between monthly or weekly payment method:");
		System.out.println("1-weekly.");
		System.out.println("2-monthly.");
        System.out.print("Enter type  the operation: ");
        operationType = reader.next().charAt(0);
       		
        
        System.out.print("Enter Rate Per Hour: ");
        hourRate = reader.nextInt();
        
		if (hourRate < 25){
			 // The rate per hour must not be less than 25 DH per hour
	        System.out.print("The rate per hour must not be less than 25 DH per hour!\r\n");
	        return;
	     }
		
		if(operationType=='1') {
	        System.out.print("The user is asked to enter the number of hours worked per week: ");
			hoursPerWeek = reader.nextInt();
			  if (hoursPerWeek > 50){ 
			      System.out.print("The total number of hours must not exceed 50 hours per week!\r\n");
			      return;
			  }
		 
			           result = hoursPerWeek*hourRate;
				        if(minHoursPerWeek < hoursPerWeek && hoursPerWeek <= 50 ) { 
				        	 overTime = hoursPerWeek-minHoursPerWeek;
				             result = (minHoursPerWeek*hourRate)+overTime*(hourRate+hourRate/2); 
				        }
				    	System.out.println("Your Weekly Salary is "+result +"DH");

			
		}else if(operationType=='2') {
	        System.out.print("The user is asked to enter the number of hours worked per month: ");

	    	 // System.out.println("Your Monthly Salary is "+result);

		}else {
    		System.out.println("Error opertaion doesnt exist!");

		}
        
       }while(true);


		 




		
	}

}
