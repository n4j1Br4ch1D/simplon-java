
public class Employee {
	final static String DEPARTMENT = "Cosmetics";
	public String firstName;
	static public String employeeLastName;
	static public String employeeBirthDate; // will do Date later
	static private double employeeSalary;
//	static private int employeeSales;
//	static private double employeeCommission;
//	static private double employeeHoursWorked;
//	static private int employeeSalePrice;

	public Employee(String firstName, String lastName, String dateInString ) { //double salary, int sales, double commission, double hoursWorked, int salePrice
		this.firstName = firstName;
		employeeLastName = lastName;
		employeeBirthDate = dateInString;
//		employeeSalary = salary;
//		employeeSales = sales;
//		employeeCommission = commission;
//		employeeHoursWorked = hoursWorked;
//		employeeSalePrice = salePrice;
	}

	public static double getSalary() {
		return employeeSalary;
	}

	public void setSalary(double salary) {
		employeeSalary = salary;
	}
}


class EmployeeFixed extends Employee {

	   public EmployeeFixed(String firstName,String lastName, String dateInString) {
			super(firstName, lastName, dateInString);
		}

	public void salary() {
		// TODO Auto-generated method stub
		
	}

	public void info() {
		// TODO Auto-generated method stub
		
	}
}

class EmployeeCommission extends Employee {

	   public EmployeeCommission(String firstName,String lastName, String birthDate) {
			super(firstName, lastName, birthDate);
		}

}

class EmployeeHourly extends Employee {

public EmployeeHourly(String firstName,String lastName, String birthDate) {
	super(firstName, lastName, birthDate);
}
}