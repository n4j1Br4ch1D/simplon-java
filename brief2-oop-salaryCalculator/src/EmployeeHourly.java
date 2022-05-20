class EmployeeHourly extends Employee {

	static double employeeHoursWorked;
	static private double employeeHoursPayRate = 100;

	public EmployeeHourly(String firstName, String lastName, String birthDate) {
		super(firstName, lastName, birthDate);
	}

	double askEmployeeHoursWorked() {
		System.out.println("Enter Employee Hours Worked: ");
		return reader.nextDouble();
	}

	public double calculateSalary() {

		// salary = hours * hourPayRate;
		// overTime = hours - normalHours;
		// overTimePayPercent50 = overTime * hourPayRate / 2;
		// salary += overTime * hourPayRate / 2;

		return employeeHoursPayRate * employeeHoursWorked;
	}
}