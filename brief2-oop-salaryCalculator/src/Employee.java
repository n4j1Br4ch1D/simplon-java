import java.util.Scanner;

public class Employee {
	final static String DEPARTMENT = "Softwares";
	public String firstName;
	public String employeeLastName;
	static String employeeBirthDate; // will do Date later //min birthdate
	static private int EmployeeAge; 
	static private int EmployeeMinHireAge = 16;
	protected static int employeePaymentDayDuration = 30; 
	static protected double employeeDailySalary = 500;
	Scanner reader = new Scanner(System.in);

	public Employee(String firstName, String lastName, String dateInString ) {
		this.firstName = firstName;
		employeeLastName = lastName;
		employeeBirthDate = dateInString;
	}

	public void setPaymentDayDuration(double salary) {
		employeeDailySalary = salary;
	}

	public static double getPaymentDayDuration() {
		return employeeDailySalary;
	}

	public void setSalary(double salary) {
		employeeDailySalary = salary;
	}

	public static double getSalary() {
		return employeeDailySalary;
	}
	
	public double calculateSalary() {
		return employeePaymentDayDuration*employeeDailySalary;
	}

	void askEmloyeeFullName() {
	    System.out.println("Enter Employee FullName(firstName lastName): ");
        String[] fullName = reader.nextLine().split("\\s+");
		firstName = fullName[0];
		employeeLastName =   fullName[1];
	}
	
	String askEmloyeeBirthDate() {
		
	 	System.out.println("Enter Employee BirthDate(D/M/Y): ");
	    return reader.next();
		
//		do {
//			
//		 	System.out.println("Enter Employee BirthDate(D/M/Y): ");
//		    return reader.nextInt();
//           DOF
//		 	//EmployeeAge = Date.now() - employeeBirthDate.getYear();
//			if (EmployeeAge < EmployeeMinHireAge)
//				System.out.printf("We only Hire People With minimum age of %s ", EmployeeMinHireAge);
//		} while (EmployeeAge < EmployeeMinHireAge);
	
	}

	void info() {	
		System.out.println("First Name: "+firstName+".");
		System.out.println("Last Name: "+employeeLastName+".");
		System.out.println("Birth Date: "+employeeBirthDate+".");
		System.out.println("Age: "+EmployeeAge+".");
		System.out.println("Department: "+DEPARTMENT+" .");
	    System.out.println("Monthly Salary: "+calculateSalary()+"."); // weekly //monthly
	}
}


class EmployeeFixed extends Employee {

	public EmployeeFixed(String firstName,String lastName, String dateInString) {
			super(firstName, lastName, dateInString);
	}

}

class EmployeeCommission extends Employee {

	static int employeeSalesNumber;
	static private double employeeSalePrice = 100;
	static private double employeeSaleCommisionPercentage = 50;
	
	public static double employeeCommission() {
		return (employeeSalesNumber*employeeSalePrice)*employeeSaleCommisionPercentage/100;

	}

	double askEmployeeSalesNumber() {
			System.out.println("Enter Employee Sales Number: ");
		   return reader.nextDouble();
	}
								

	public EmployeeCommission(String firstName,String lastName, String birthDate) {
			super(firstName, lastName, birthDate);
	}

	public double calculateSalary() {
//		if(employeeSalesNumber > 100) {
//			return employeeSaleCommisionPercentage = 80;
//		}
		return (employeeDailySalary*employeePaymentDayDuration) + employeeCommission();
	}

}

class EmployeeHourly extends Employee {   

	static double employeeHoursWorked;
	static private double employeeHoursPayRate = 100;

	public EmployeeHourly(String firstName,String lastName, String birthDate) {
			super(firstName, lastName, birthDate);
	}

	double askEmployeeHoursWorked() {
		System.out.println("Enter Employee Hours Worked: ");
	     return reader.nextDouble();
   }

	public double calculateSalary() {

//		salary = hours * hourPayRate;
//				overTime = hours - normalHours;
//				overTimePayPercent50 = overTime * hourPayRate / 2;
//				salary += overTime * hourPayRate / 2;
		
		return employeeHoursPayRate * employeeHoursWorked;
	}
}
