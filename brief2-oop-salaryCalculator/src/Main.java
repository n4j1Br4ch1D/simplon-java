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
		System.out.format("|         Alpha Version 0.0.1       |%n");
		System.out.format("+-----------------+-----------------+%n");

        outerloop:
		do {
			System.out.println("=================================\n");

			System.out.println("Choose Type of Operation:");
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
			  	  employee.employeeBirthDate =  employee.askEmloyeeBirthDate();
                  employee.info();

				 if (operationType == '1') {
				   	  EmployeeFixed employeeFix = new EmployeeFixed(null, null, null);
					  
						System.out.println("hhh"+employeeFix.calculateSalary());
						employeeFix.info();
  
			     } else if (operationType == '2') {						
				       EmployeeCommission employeeCom = new EmployeeCommission(null, null, null);
				       EmployeeCommission.employeeSalesNumber = (int) employeeCom.askEmployeeSalesNumber();
				   
					System.out.println("hhh"+employeeCom.calculateSalary());

				   employeeCom.info();

				   
                 } else {
				  System.out.println("Employee Hourly\n");
  				   EmployeeHourly employeeHour = new EmployeeHourly(null, null, null);
  				   employeeHour.employeeHoursWorked = employeeHour.askEmployeeHoursWorked();
					System.out.println("hhh"+employeeHour.calculateSalary());

  				     employeeHour.info();

                 }
				   

			} else if (operationType == '4') {
				CEO.info();				
		    } else if (operationType == '5') {
			    COO.info();	// tari9a m5talfa			    
			} else if (operationType == '9') {

				do{

					System.out.println("\n\n##### Settings #####\n");
					System.out.println("Choose Type of Operation:");
					//currency;
//					System.out.printf("1-set Salary:........................%s\n", employee.getSalary());
					//employeePaymentDayDuration
					//EmployeeMinHireAge
//					System.out.printf("2-set Sale Price:...................%s\n", EmployeeCommission.getSalePrice());
//					System.out.printf("3-Set Sale Commision Percentage:..%s%%\n", EmployeeCommission.getCommisionPercentage());
//					System.out.printf("4-set Hours Pay Rate:............%s\n", employeeHour.getHoursPayRate());
					//employeeSalesNumberSpecial
					//employeeSaleCommisionPercentageSpecial 
					//employeeHoursWorkedSpecial
					//employeeHoursPayRateSpecial
					//ceo 
					//coo
					
					System.out.println("9-Return.\n0-Exit!");

					operationType = reader.next().charAt(0);
					switch (operationType) {
						case '0':
						System.out.println("Exit!");
						reader.close();
						break outerloop;
						case '9':
						System.out.println("Return!");
						break;
						case '1':
						  //employee.setSalary();

                         
						default:
							System.out.println("Error opertaion doesnt exist!");
							continue;
					}

		        }while(true);


		    } else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}
		
		}while(true);

		reader.close();
	}

}


