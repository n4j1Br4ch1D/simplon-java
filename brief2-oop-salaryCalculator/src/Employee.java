import java.util.Scanner;

public class Employee {
	final static String DEPARTMENT = "Softwares";
	public String firstName;
	public String employeeLastName;
	static String employeeBirthDate; // will do Date later //min birthdate
	static private int EmployeeAge; // will do Date later //min birthdate
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
	    String hhh = "najib rachid";
        String[] fullName = hhh.split("\\s+");  //reader.next()
		firstName = fullName[0];
		employeeLastName =   fullName[1];
	}
	
	String askEmloyeeBirthDate() {
		
	 	System.out.println("Enter Employee BirthDate(D/M/Y): ");
	    return reader.next();
		
//		do {
//			
//		 	System.out.println("Enter Employee BirthDate(D/M/Y): ");
//			
//		 	//EmployeeAge = Date.now() - employeeBirthDate.getYear();
//		 	int EmployeeAge = 14;
//			if (EmployeeAge < EmployeeMinHireAge)
//				System.out.printf("We only Hire People With minimum age of %s ", EmployeeMinHireAge);
//		} while (EmployeeAge < EmployeeMinHireAge);
	
		//int birthDate = reader.nextInt();
	}

	void info() {
		System.out.println("Full Name: "+firstName+" "+employeeLastName+".");
		System.out.println("Birth Date: "+DEPARTMENT+" Department.");
		System.out.println("Department: "+DEPARTMENT+" .");
	    System.out.println("Monthly Salary: "+calculateSalary()+".");
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
		//     500*30 + (5*100)*50/100
	}

}

class EmployeeHourly extends Employee {   

	static private double employeeHoursWorked;
	static private double employeeHoursPayRate = 100;

	public EmployeeHourly(String firstName,String lastName, String birthDate) {
			super(firstName, lastName, birthDate);
	}

	private void askEmployeeHoursWorked() {
		System.out.println("Enter Employee Hours Worked: ");
	   // double sales = reader.nextDouble();
   }

	public double calculateSalary() {

//		salary = hours * hourPayRate;
//				overTime = hours - normalHours;
//				overTimePayPercent50 = overTime * hourPayRate / 2;
//				salary += overTime * hourPayRate / 2;
		
		return employeeHoursPayRate * employeeHoursWorked;
	}
}

//make it work;
//improve features.
//check oop.
//make all oop.
