import java.util.Scanner;

public class Employee {
  final static String DEPARTMENT = "Softwares";
  public String employeeFirstName;
  public String employeeLastName;
  String employeeBirthDate; // will do Date later //min birthdate
  static private int EmployeeAge;
  static private int EmployeeMinHireAge = 16;
  static private String currency = "$";
  protected static int employeePaymentDayDuration = 30;
  static protected double employeeDailySalary = 500;
  Scanner reader = new Scanner(System.in);

  public Employee(String firstName, String lastName, String employeeBirthDate) {
    employeeFirstName = firstName;
    employeeLastName = lastName;
    this.employeeBirthDate = employeeBirthDate;
  }

  public static void setMinHireAge(int minHireAge) {
    EmployeeMinHireAge = minHireAge;
  }

  public static double getMinHireAge() {
    return EmployeeMinHireAge;
  }

  public static void setCurrency(String currencyCode) {
    currency = currencyCode;
  }

  public static String getCurrency() {
    return currency;
  }

  public static void setPaymentDayDuration(int paymentDayDuration) {
    employeePaymentDayDuration = paymentDayDuration;
  }

  public static double getPaymentDayDuration() {
    return employeePaymentDayDuration;
  }

  public static void setDailySalary(double salary) {
    employeeDailySalary = salary;
  }

  public static double getDailySalary() {
    return employeeDailySalary;
  }

  public double calculateSalary() {
    return employeePaymentDayDuration * employeeDailySalary;
  }

  void askEmployeeFullName() {
    System.out.println("Enter Employee FullName(firstName lastName): ");
    String[] fullName = reader.nextLine().split("\\s+");
    employeeFirstName = fullName[0];
    employeeLastName = fullName[1];
  }

  String askEmployeeBirthDate() {

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
    System.out.println("\nFirst Name: " + employeeFirstName + ".");
    System.out.println("Last Name: " + employeeLastName + ".");
    System.out.println("Birth Date: " + employeeBirthDate + ".");
    System.out.println("Age: " + EmployeeAge + ".");
    System.out.println("Department: " + DEPARTMENT + ".");
    System.out.println("Monthly Salary: " + calculateSalary() + " " + getCurrency() + ".");
  }
}
