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

	public Employee(String firstName, String lastName, String dateInString) {
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
		return employeePaymentDayDuration * employeeDailySalary;
	}

	void askEmployeeFullName() {
		System.out.println("Enter Employee FullName(firstName lastName): ");
		String[] fullName = reader.nextLine().split("\\s+");
		firstName = fullName[0];
		employeeLastName = fullName[1];
	}

	String askEmloyeeBirthDate() {

		System.out.println("Enter Employee BirthDate(D/M/Y): ");
		return reader.next();

		// do {
		//
		// System.out.println("Enter Employee BirthDate(D/M/Y): ");
		// return reader.nextInt();
		// DOF
		// //EmployeeAge = Date.now() - employeeBirthDate.getYear();
		// if (EmployeeAge < EmployeeMinHireAge)
		// System.out.printf("We only Hire People With minimum age of %s ",
		// EmployeeMinHireAge);
		// } while (EmployeeAge < EmployeeMinHireAge);

	}

	void info() {
		System.out.println("First Name: " + firstName + ".");
		System.out.println("Last Name: " + employeeLastName + ".");
		System.out.println("Birth Date: " + employeeBirthDate + ".");
		System.out.println("Age: " + EmployeeAge + ".");
		System.out.println("Department: " + DEPARTMENT + " .");
		System.out.println("Monthly Salary: " + calculateSalary() + "."); // weekly //monthly
	}
}
