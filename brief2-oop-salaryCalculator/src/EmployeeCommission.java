class EmployeeCommission extends Employee {

	static int employeeSalesNumber;
	static private double employeeSalePrice = 100;
	static private double employeeSaleCommisionPercentage = 50;

	public static double employeeCommission() {
		return (employeeSalesNumber * employeeSalePrice) * employeeSaleCommisionPercentage / 100;

	}

	double askEmployeeSalesNumber() {
		System.out.println("Enter Employee Sales Number: ");
		return reader.nextDouble();
	}

	public EmployeeCommission(String firstName, String lastName, String birthDate) {
		super(firstName, lastName, birthDate);
	}

	public double calculateSalary() {
		// if(employeeSalesNumber > 100) {
		// return employeeSaleCommisionPercentage = 80;
		// }
		return (employeeDailySalary * employeePaymentDayDuration) + employeeCommission();
	}

}