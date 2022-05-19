import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		char operationType;
		Scanner reader = new Scanner(System.in);

		System.out.format("+-----------------+-----------------+%n");
		System.out.format("|           SalaryCalcultor         |%n");
		System.out.format("|      NajibRachid &  OmarDbaa      |%n");
		System.out.format("+-----------------+-----------------+%n");

		do {
			System.out.println("\n\nChoose Type of Employee:");
			System.out.println("1-Employee Fixed.\n2-Employee Commission.\n3-Employee Hourly\n0-Exit.");
			System.out.print("Enter type of the operation: ");
			operationType = reader.next().charAt(0);
			if (operationType == '0') {
				System.out.println("Exit!");
				reader.close();
				break;
			} else if (operationType == '1') {
		
			} else if (operationType == '2') {

			} else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}
		
            System.out.println("Enter Employee FullName: ");
	     	String fullname = reader.nextLine();
		    System.out.println("Enter Employee BirthDate: ");
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

//	class Employee {
//
//		final static String DEPARTMENT = "Cosmetics";
//		static public String firstName;
//		static public String employeeLastName;
//		static public int employeeBirthDate;
//		static private double employeeSalary;
//		static private int employeeSales;
//		static private double employeeCommission;
//		static private double employeeHoursWorked;
//		static private int employeeSalePrice;
//
//		public Employee(String firstName, String lastName,  int birthDate,double salary, int sales, double commission, double hoursWorked, int salePrice ) {
//			this.firstName = firstName;
//			employeeLastName = lastName;
//			employeeBirthDate = birthDate;
//			employeeSalary = salary;
//			employeeSales = sales;
//			employeeCommission = commission;
//			employeeHoursWorked = hoursWorked;
//			employeeSalePrice = salePrice;
//		}
//
//		public static double getSalary() {
//			return employeeSalary;
//		}
//
//		public void setSalary(double salary) {
//			employeeSalary = salary;
//		}
//
//	}
//
//	class EmployeeFixed extends Employee {
//
//		public EmployeeFixed(String name, int age) {
//			super(name, age);
//		}
//
//	}

//	class EmployeeCommission extends Employee {
//
//		public EmployeeCommission(String name, int age) {
//			super(name, age);
//		}
//
//	}

//class EmployeeHourly extends Employee {
//
//    public EmployeeHourly(String name, int age) {
//		super(name, age);
//	}
}
