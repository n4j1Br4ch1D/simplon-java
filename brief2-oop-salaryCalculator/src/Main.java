import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

  public static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  public static Date dateParser(String dateStr) {
    try {
      return dateFormatter.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected static Employee employee = new Employee(null, null, null);
  private static EmployeeFixed CEO = new EmployeeFixed("Najib", "Rachid", "7-07-1996"); // special
  private static EmployeeFixed COO = new EmployeeFixed("Omar", "Dbaa", "7-08-1996"); // special

  public static void main(String[] args) {

    char operationType;
    Scanner reader = new Scanner(System.in);

    System.out.format("+-----------------+-----------------+%n");
    System.out.format("|        EasySalaryCalculator       |%n");
    System.out.format("|       NajibRachid & OmarDbaa      |%n");
    System.out.format("|         Alpha Version 0.0.1       |%n");
    System.out.format("+-----------------+-----------------+%n");

    outerloop: do {

      System.out.println("\n\nChoose Type of Operation:");
      System.out.println(
          "1-Employee Fixed.\n2-Employee Commission.\n3-Employee Hourly.\n4-CEO`s Salary.\n5-COO`s Salary.\n6-settings\n0-Exit!");
      System.out.print("Enter type of the operation: ");
      operationType = reader.next().charAt(0);
      if (operationType == '0') {
        System.out.println("Exit!");
        reader.close();
        break;
      } else if (operationType == '1' || operationType == '2' || operationType == '3') { // Employee Type;
        if (operationType == '1') {
          EmployeeFixed employeeFix = new EmployeeFixed(null, null, null);
          employeeFix.askEmployeeFullName();
          employeeFix.employeeBirthDate = employeeFix.askEmployeeBirthDate();
          employeeFix.info();
        } else if (operationType == '2') {
          EmployeeCommission employeeCom = new EmployeeCommission(null, null, null);
          employeeCom.askEmployeeFullName();
          employeeCom.employeeBirthDate = employeeCom.askEmployeeBirthDate();
          employeeCom.employeeSalesNumber = (int) employeeCom.askEmployeeSalesNumber();
          employeeCom.info();
        } else {
          EmployeeHourly employeeHour = new EmployeeHourly(null, null, null);
          employeeHour.askEmployeeFullName();
          employeeHour.employeeBirthDate = employeeHour.askEmployeeBirthDate();
          employeeHour.employeeHoursWorked = employeeHour.askEmployeeHoursWorked();
          employeeHour.info();
        }
      } else if (operationType == '4') {
        CEO.info();
      } else if (operationType == '5') {
        COO.info(); // tari9a m5talfa
      } else if (operationType == '6') {

        do {
          System.out.println("\n\n##### Settings #####\n");
          System.out.println("Choose Type of Operation:");
          System.out.printf("1-set Min Hire Age:..............................................%s\n", Employee.getMinHireAge());
          System.out.printf("2-set Currency:..................................................%s\n", Employee.getCurrency());
          System.out.printf("3-set Payment Day Duration:......................................%s\n",
              Employee.getPaymentDayDuration());
          System.out.printf("4-set Daily Salary:..............................................%s\n", Employee.getDailySalary());
          System.out.printf("5-set Sale Price:................................................%s\n", EmployeeCommission.getSalePrice());
          System.out.printf("6-set Sale Commision Percentage:.................................%s\n",
              EmployeeCommission.getSaleCommisionPercentage());
          System.out.printf("7-set Special Sales Number:......................................%s\n",
              EmployeeCommission.getSpecialSalesNumber());
          System.out.printf("8-set Special Sales Commision Percentage:........................%s\n",
              EmployeeCommission.getSpecialSaleCommisionPercentage());
          System.out.printf("9-set Hours Pay Rate:............................................%s\n", EmployeeHourly.getHoursPayRate());
          System.out.printf("a-set Special Hours Worked:......................................%s\n",
              EmployeeHourly.getSpecialHoursWorked());
          System.out.printf("b-set Special Hours Pay Rate:....................................%s\n",
              EmployeeHourly.getSpecialHoursPayRate());
          System.out.println("c-Return.\n0-Exit!");
          System.out.print("Enter type of the operation: ");

          operationType = reader.next().charAt(0);
          switch (operationType) {
            case '0':
              System.out.println("Exit!");
              reader.close();
              break outerloop;
            case 'c':
              System.out.println("Return!");
              continue outerloop;
            case '1':
              System.out.println("Plz! Enter New Min Hire Age: ");
              Employee.setMinHireAge(reader.nextInt());
              break;
            case '2':
              System.out.println("Plz! Enter New Currency: ");
              Employee.setCurrency(reader.next());
              break;
            case '3':
              System.out.println("Plz! Enter New Payment Day Duration: ");
              Employee.setPaymentDayDuration(reader.nextInt());
              break;
            case '4':
              System.out.println("Plz! Enter New Daily Salary: ");
              Employee.setDailySalary(reader.nextDouble());
              break;
            case '5':
              System.out.println("Plz! Enter New Sale Price: ");
              EmployeeCommission.setSalePrice(reader.nextDouble());
              break;
            case '6':
              System.out.println("Plz! Enter New Sale Commision Percentage: ");
              EmployeeCommission.setSaleCommisionPercentage(reader.nextDouble());
              break;
            case '7':
              System.out.println("Plz! Enter New Special Sales Number: ");
              EmployeeCommission.setSpecialSalesNumber(reader.nextDouble());
              break;
            case '8':
              System.out.println("Plz! Enter New Special Sale Commision Percentage: ");
              EmployeeCommission.setSpecialSaleCommisionPercentage(reader.nextDouble());
              break;
            case '9':
              System.out.println("Plz! Enter New Hours Pay Rate: ");
              EmployeeHourly.setHoursPayRate(reader.nextDouble());
              break;
            case 'a':
              System.out.println("Plz! Enter New Special Hours Worked: ");
              EmployeeHourly.setSpecialHoursWorked(reader.nextDouble());
              break;     
            case 'b':
              System.out.println("Plz! Enter New Special Hours Pay Rate: ");
              EmployeeHourly.setSpecialHoursPayRate(reader.nextDouble());
              break;
              
            default:
              System.out.println("Error opertaion doesnt exist!");
              continue;
          }

        } while (true);

      } else {
        System.out.println("Error opertaion doesnt exist!");
        continue;
      }

    } while (true);

    reader.close();
  }

}
