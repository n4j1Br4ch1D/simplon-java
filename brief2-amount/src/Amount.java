import java.util.Scanner;

public class Amount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("****** AmountCalculator ******");
		String name;
		double result, overTime, hoursPerWeek, hoursPerMonth, weeklyHourRate, monthlyHourRate, minHoursPerWeek = 40,
				minHoursPerMonth = 180, maxHoursPerWeek = 50, maxHoursPerMonth = 200;
		char operationType;

		Scanner reader = new Scanner(System.in); // the new keyword is used to create an instance of the class.
		// A message that prompts the employee to enter their name
		System.out.println("Enter your Name: ");
		name = reader.next();
		// A welcome message on behalf of the user
		System.out.println("Hi there, " + name + "!");

		do {
			System.out.println("\nChoose between monthly or weekly payment method:");
			System.out.println("1-weekly.");
			System.out.println("2-monthly.");
			System.out.print("Enter type  the operation: ");
			operationType = reader.next().charAt(0);

			if (operationType == '1') {

				do {
					System.out.print("Enter the number of hours worked per week: ");
					hoursPerWeek = reader.nextDouble();
					if(hoursPerWeek > maxHoursPerWeek) {
						System.out.print("The total number of hours must not exceed "+maxHoursPerWeek+" hours per week!\r\n");
					}
				}while(hoursPerWeek > maxHoursPerWeek);
			
                
				do {
				System.out.print("Enter Rate Per Hour: ");
				weeklyHourRate = reader.nextDouble();
				if (weeklyHourRate < 25) {
					// The rate per hour must not be less than 25 DH per hour
					System.out.print("The rate per hour must not be less than 25 DH per hour!\r\n");
				}
			   }while(weeklyHourRate < 25);
				
				result = hoursPerWeek * weeklyHourRate;
				if (minHoursPerWeek < hoursPerWeek && hoursPerWeek <= maxHoursPerWeek) {
					overTime = hoursPerWeek - minHoursPerWeek;
					result = (minHoursPerWeek * weeklyHourRate) + overTime * (weeklyHourRate + weeklyHourRate / 2);
				}
				System.out.println("Your Weekly Salary is " + result + " DH");

			} else if (operationType == '2') {

		  do{
				System.out.print("Enter the number of hours worked per month: ");
				hoursPerMonth = reader.nextDouble();
				if (hoursPerMonth > maxHoursPerMonth) {
					System.out.print("The total number of hours must not exceed "+maxHoursPerMonth+" hours per month!\r\n");
				}
			}while(hoursPerMonth > maxHoursPerMonth);
			
		    do {
				System.out.print("Enter Rate Per Hour: ");
				monthlyHourRate = reader.nextDouble();
				if (monthlyHourRate < 20) {
					// The rate per hour must not be less than 20 DH per hour
					System.out.print("The rate per hour must not be less than 20 DH per hour!\r\n");
				}
			  }while(monthlyHourRate < 20);
				
				result = hoursPerMonth * monthlyHourRate;
				if (minHoursPerMonth < hoursPerMonth && hoursPerMonth <= maxHoursPerMonth) {
					overTime = hoursPerMonth - minHoursPerMonth;
					result = (minHoursPerMonth * monthlyHourRate) + overTime * (monthlyHourRate + monthlyHourRate / 2);
				}
				System.out.println("Your  Monthly  Salary is " + result + " DH");

			} else {
				System.out.println("Error opertaion doesnt exist!");

			}

		} while (true);

	}

}
