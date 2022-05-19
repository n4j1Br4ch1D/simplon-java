
public class Main {

	public static void main(String[] args) {

	}

	class Employee {

		final static String DEPARTMENT = "Cosmetics";
		static public String firstName;
		static public String employeeLastName;
		static public int employeeBirthDate;
		static private double employeeSalary;
		static private int employeeSales;
		static private double employeeCommission;
		static private double employeeHoursWorked;
		static private int employeeSalePrice;

		public Employee(String firstName, String lastName) {
			this.firstName = firstName;
			employeeLastName = lastName;
			employeeBirthDate = birthDate;
			employeeSalary = salary;
			employeeSales = sales;
			employeeCommission = commission;
			employeeHoursWorked = hoursWorked;
			employeeSalePrice = salePrice;
		}

		public static double getSalary() {
			return employeeSalary;
		}

		public void setSalary(double salary) {
			employeeSalary = salary;
		}

	}

	class EmployeeFixed extends Employee {

		public EmployeeFixed(String name, int age) {
			super(name, age);
		}

	}

	class EmployeeCommission extends Employee {

		public EmployeeCommission(String name, int age) {
			super(name, age);
		}

	}

class EmployeeHourly extends Employee {

    public EmployeeHourly(String name, int age) {
		super(name, age);
	}
}
