import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		char operationType;
		Scanner reader = new Scanner(System.in);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		System.out.format("+-----------------+-----------------+%n");
		System.out.format("|           SalaryCalcultor         |%n");
		System.out.format("|      NajibRachid &  OmarDbaa      |%n");
		System.out.format("+-----------------+-----------------+%n");

		do {
			System.out.println("\n\nChoose Type of Employee:");
			System.out.println("1-Employee Fixed.\n2-Employee Commission.\n3-Employee Hourly.\n4-CEO`s Salary.\n5-COO`s Salary.\n0-Exit.");
			System.out.print("Enter type of the operation: ");
			operationType = reader.next().charAt(0);
			if (operationType == '0') {
				System.out.println("Exit!");
				reader.close();
				break;
			} else if (operationType == '1') {
				
		
			} else if (operationType == '2') {

			} else if (operationType == '3') {
				
			} else if (operationType == '4') {

				
				
		        Date CeoBirthDateFormated = null;

			        String dateInString = "7-07-1996";



//			            Date CeoBirthDateFormated = dateFormatter.parse(dateInString);
			            System.out.println(CeoBirthDateFormated);
						

//					EmployeeFixed CEO = new EmployeeFixed("Najib", "Rachid", CeoBirthDateFormated);



				//najibObj.setSalary(salary);
				    
		    } else if (operationType == '5') {
		           
		    }  else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}
		
            System.out.println("Enter Employee FullName(firstName lastName): ");
	     	String fullname = reader.next();
	     	 
	
	     	
		    System.out.println("Enter Employee BirthDate(D/M/Y): ");
		    int birthDate = reader.nextInt();
			
			//2
	    	System.out.println("Enter Employee Salary: ");
		    double salary = reader.nextDouble();

			System.out.println("Enter Employee Sales Number: ");
		    double sales = reader.nextDouble();
			
			System.out.println("Enter Employee Sales commission: ");
		    double commission = reader.nextDouble();
			
		
			// employeeHoursWorked = hoursWorked;
			// employeeSalePrice = salePrice;

//		 Employee employeeObj = new Employee();
//		 employeeObj.setSalary(salary);
		
		}while(true);

		reader.close();
	}

	class Employee {

		final static String DEPARTMENT = "Cosmetics";
		public String firstName;
		static public String employeeLastName;
		static public Date employeeBirthDate;
		static private double employeeSalary;
		static private int employeeSales;
		static private double employeeCommission;
		static private double employeeHoursWorked;
		static private int employeeSalePrice;

		public Employee(String firstName, String lastName, Date birthDate ) { //double salary, int sales, double commission, double hoursWorked, int salePrice
			this.firstName = firstName;
			employeeLastName = lastName;
			employeeBirthDate = birthDate;
//			employeeSalary = salary;
//			employeeSales = sales;
//			employeeCommission = commission;
//			employeeHoursWorked = hoursWorked;
//			employeeSalePrice = salePrice;
		}

		public static double getSalary() {
			return employeeSalary;
		}

		public void setSalary(double salary) {
			employeeSalary = salary;
		}

	}

	class EmployeeFixed extends Employee {

		   public EmployeeFixed(String firstName,String lastName, Date birthDate) {
				super(firstName, lastName, birthDate);
			}
	}

	class EmployeeCommission extends Employee {

		   public EmployeeCommission(String firstName,String lastName, Date birthDate) {
				super(firstName, lastName, birthDate);
			}

	}

class EmployeeHourly extends Employee {

   public EmployeeHourly(String firstName,String lastName, Date birthDate) {
		super(firstName, lastName, birthDate);
	}
}

}


