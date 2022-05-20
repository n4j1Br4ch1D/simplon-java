import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    public static Date dateParser(String dateStr) {
        try {
            return dateFormatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
    }
    
	private static EmployeeFixed CEO = new EmployeeFixed("Najib", "Rachid", "7-07-1996");  //special 
	private static EmployeeFixed COO = new EmployeeFixed("Omar", "Dbaa", "7-08-1996");  //special

	public static void main(String[] args) {

		char operationType;
		Scanner reader = new Scanner(System.in);

		System.out.format("+-----------------+-----------------+%n");
		System.out.format("|           SalaryCalcultor         |%n");
		System.out.format("|       NajibRachid & OmarDbaa      |%n");
		System.out.format("|                V0.0.1             |%n");
		System.out.format("+-----------------+-----------------+%n");

		do {
			System.out.println("\n\nChoose Type of Operation:");
			System.out.println("1-Employee Fixed.\n2-Employee Commission.\n3-Employee Hourly.\n4-CEO`s Salary.\n5-COO`s Salary.\n9-settings\n0-Exit!");
			System.out.print("Enter type of the operation: ");
			operationType = reader.next().charAt(0);
			if (operationType == '0') {
				System.out.println("Exit!");
				reader.close();
				break;
			}else if(operationType == '1' || operationType == '2' || operationType == '3'){ //Employee Type;
				  Employee employee = new Employee(null, null, null);
				  employee.askEmloyeeFullName();
				 // Employee.employeeBirthDate =  employee.askEmloyeeBirthDate();

				 if (operationType == '1') {
						System.out.println("Employee Fixed\n");

					  EmployeeFixed employeeFix = new EmployeeFixed(null, null, null);
					  
						System.out.println("hhh"+employeeFix.calculateSalary());


			     } else if (operationType == '2') {
						System.out.println("Employee Commission\n");
						

				   EmployeeCommission employeeCom = new EmployeeCommission(null, null, null);
				   employeeCom.askEmployeeSalesNumber();
				   employeeCom.info();

				   
                 } else {
				  System.out.println("Employee Hourly\n");
  				   EmployeeHourly employeeHour = new EmployeeHourly(null, null, null);
  				     employeeHour.info();

                 }
				   

			} else if (operationType == '4') {
				CEO.info();				
		    } else if (operationType == '5') {
			    COO.info();	// tari9a m5talfa			    
			} else if (operationType == '9') {
				System.out.println("\n\n##### Settings #####\n");
				System.out.println("Choose Type of Operation:");
				System.out.printf("1-set Salary:........................%s\n", 9000);
				System.out.printf("2-set Sale Price:...................%s\n", 100);
				System.out.printf("3-Set Sale Commision Percentage:            %s%%\n", 10);
				System.out.printf("3-set Hours Pay Rate:           %s\n", 100);
				operationType = reader.next().charAt(0);
				//
				//currency;
				//EmployeeMinHireAge
				
				//employeeSalesNumberSpecial
				//employeeSaleCommisionPercentageSpecial 

	
				//employeeHoursWorkedSpecial
				//employeeHoursPayRateSpecial

				System.out.println("9-Return.\n0-Exit!");

				/* 
   
			
	    	System.out.println("Enter Employee Salary: ");
		    double salary = reader.nextDouble();
		    employeeObj.setSalary(salary);

			System.out.println("Enter Employee Sales price: ");
		    double commission = reader.nextDouble();

			System.out.println("Enter Employee Sales commission percentage: ");
		    double commission = reader.nextDouble();


			System.out.println("Enter Hours Pay Rate: ");
		    double hoursPayRate = reader.nextDouble();
			



				*/
		    } else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}
		
		}while(true);

		reader.close();
	}

}


