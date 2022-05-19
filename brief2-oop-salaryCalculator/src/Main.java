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
    
	private static EmployeeFixed CEO = new EmployeeFixed("Najib", "Rachid", "7-07-1996");
	private static EmployeeFixed COO = new EmployeeFixed("Omar", "Dbaa", "7-08-1996");

	public static void main(String[] args) {

		char operationType;
		Scanner reader = new Scanner(System.in);
        
     

		System.out.format("+-----------------+-----------------+%n");
		System.out.format("|           SalaryCalcultor         |%n");
		System.out.format("|      NajibRachid &  OmarDbaa      |%n");
		System.out.format("+-----------------+-----------------+%n");

		do {
			System.out.println("\n\nChoose Type of Employee:");
			System.out.println("1-Employee Fixed.\n2-Employee Commission.\n3-Employee Hourly.\n4-CEO`s Salary.\n5-COO`s Salary.\n0-Exit.");
			System.out.print("Enter type of the operation: ");
			operationType = reader.next().charAt(0);
			if (operationType == '0') {
				System.out.println("Exit!");
				reader.close();
				break;
			} else if (operationType == '1') {
				
		
			} else if (operationType == '2') {

			} else if (operationType == '3') {
				
			} else if (operationType == '4') {
				CEO.info();				
		    } else if (operationType == '5') {
				COO.info();				    
		    }  else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}
		
            System.out.println("Enter Employee FullName(firstName lastName): ");
	     	String fullname = reader.next();
	     	 
	
	     	
		    System.out.println("Enter Employee BirthDate(D/M/Y): ");
		    int birthDate = reader.nextInt();
			
			//2
	    	System.out.println("Enter Employee Salary: ");
		    double salary = reader.nextDouble();

			System.out.println("Enter Employee Sales Number: ");
		    double sales = reader.nextDouble();
			
			System.out.println("Enter Employee Sales commission: ");
		    double commission = reader.nextDouble();
			
		
			// employeeHoursWorked = hoursWorked;
			// employeeSalePrice = salePrice;

//		 Employee employeeObj = new Employee();
//		 employeeObj.setSalary(salary);
		
		}while(true);

		reader.close();
	}

}


