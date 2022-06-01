package brief5.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

import utils.PropertiesReader;

public class dbConnection {


    private static final String PROPERTIES_DB_FILE = "src/resources/db/dbconnection.properties";
    private static final String DRIVER = "driverClassName";
    private static final String URL = "jdbcUrl";
    private static final String USER = "postgres.username";
    private static final String PASS = "postgres.password";


    	 
	 
	//  private String databaseUrl = "";
	//  private String databaseUser = "";
	//  private String databasePassword = "";
	//  private String databaseDriver = "";

	 




    // public DBConnection() {
	
	// 	Properties properties = PropertiesReader.getProperties(PROPERTIES_DB_FILE);
	//     String databaseDriver = properties.getProperty(DRIVER);
	//     String databaseUrl = properties.getProperty(URL);
	//     String databaseUser= properties.getProperty(USER);
	//     String databasePassword = properties.getProperty(PASSWORD);

	//  }

    /**
     * Get a connection to database
     * @return Connection object
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws ClassNotFoundException
    {
      try {
          DriverManager.registerDriver(new Driver());
          Class.forName(DRIVER);
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }

    


    /**
     * Test Connection
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = dbConnection.getConnection();
    }

}





	


