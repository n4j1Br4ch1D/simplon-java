class EmployeeCommission extends Employee {

	static int employeeSalesNumber;
	static private double employeeSalePrice = 100;
	static private double employeeSaleCommisionPercentage = 50;
	static private double employeeSpecialSalesNumber = 55;
	static private double employeeSpecialSaleCommisionPercentage = 80;


	public static double employeeCommission() {
		return (employeeSalesNumber * employeeSalePrice) * employeeSaleCommisionPercentage / 100;

	}
  
  public static void setSalePrice(double salePrice) {
    employeeSalePrice = salePrice;
  }

  public static double getSalePrice() {
    return employeeSalePrice;
  }
  
  public static void setSaleCommisionPercentage(double saleCommisionPercentage) {
    employeeSaleCommisionPercentage = saleCommisionPercentage;
  }

  public static double getSaleCommisionPercentage() {
    return employeeSaleCommisionPercentage;
  }	
  
  public static void setSpecialSalesNumber(double specialSalesNumber) {
    employeeSpecialSalesNumber = specialSalesNumber;
  }

  public static double getSpecialSalesNumber() {
    return employeeSpecialSalesNumber;
  }	

  public static void setSpecialSaleCommisionPercentage(double specialSaleCommisionPercentage) {
    employeeSpecialSaleCommisionPercentage = specialSaleCommisionPercentage;
  }

  public static double getSpecialSaleCommisionPercentage() {
    return employeeSpecialSaleCommisionPercentage;
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