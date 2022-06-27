package helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
    private static final String PROPERTIES_DB_FILE = "src/config/dbconnection.properties";
    private static final String DRIVER = "driverClassName";
    private static final String URL = "jdbcUrl";
    private static final String USER = "postgres.username";
    private static final String PASS = "postgres.password";
	 
	 private static Properties properties = PropertiesReader.getProperties(PROPERTIES_DB_FILE);
	 private static String databaseDriver = properties.getProperty(DRIVER);
	 private static String databaseUrl =  properties.getProperty(URL);
	 private static String databaseUser = properties.getProperty(USER);
	 private static String databasePassword = properties.getProperty(PASS);
	
	    
	 public static Connection getConnection() {
		 
		 try{ 
	         Class.forName(databaseDriver);
			 return DriverManager.getConnection(databaseUrl, databaseUser, databasePassword );

		 }catch(SQLException | ClassNotFoundException e){
			 e.printStackTrace();
	         System.out.println("Error Opning DB!");
			 
		 }
		 return null;
	 }
   
}
