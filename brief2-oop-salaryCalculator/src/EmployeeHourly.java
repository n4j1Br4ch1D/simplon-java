class EmployeeHourly extends Employee {

	static double employeeHoursWorked;
	static private double employeeHoursPayRate = 100;
  static private double employeeSpecialHoursWorked = 5;
	static private double employeeSpecialHoursPayRate = 200;

	public EmployeeHourly(String firstName, String lastName, String birthDate) {
		super(firstName, lastName, birthDate);
	}

	double askEmployeeHoursWorked() {
    System.out.println("Enter Employee Hours Worked Per Day: ");
		return reader.nextDouble();
	}

  public static void setHoursPayRate(double hoursPayRate) {
    employeeHoursPayRate = hoursPayRate;
  }

  public static double getHoursPayRate() {
    return employeeHoursPayRate;
  }
  
  public static void setSpecialHoursWorked(double specialHoursWorked) {
    employeeSpecialHoursWorked = specialHoursWorked;
  }

  public static double getSpecialHoursWorked() {
    return employeeSpecialHoursWorked;
  }	

    public static void setSpecialHoursPayRate(double specialHoursPayRate) {
    employeeSpecialHoursPayRate = specialHoursPayRate;
  }

  public static double getSpecialHoursPayRate() {
    return employeeSpecialHoursPayRate;
  }	
  
  public double calculateSalary() {
    if(employeeHoursWorked>=employeeSpecialHoursWorked){
        return employeePaymentDayDuration * employeeSpecialHoursPayRate * employeeHoursWorked;
    }
		return employeePaymentDayDuration * employeeHoursPayRate * employeeHoursWorked;
	}
}