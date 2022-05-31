// ODBC vs JDBC
// JDBS vs ORM vs DAO?
// java.sql VS javax.sql 
import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
   
	
   public static String tableName = "users";

   public static void main( String args[] ) {
	// listUsers(1);
    // addUser("latifa@anmoon.ma", "qwerty123", "latifa", "amougauay");
     // approveUser(9);
	// viewUserByEmail("latifa@anmoon.ma");
	deleteUser(9);
 }
   
   public static void listUsers(int limit) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Ahanou",
	            "postgres", "root");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM "+tableName+" LIMIT " + limit + ";" );
	         while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  firstrName = rs.getString("first_name");
	            String  lastName = rs.getString("last_name");
	            String  email = rs.getString("email");
	            String  roleType = rs.getString("role_type");
                boolean approved = rs.getBoolean("approved");
	            
	            System.out.println( "ID = " + id );
	            System.out.println( "First_Name = " + firstrName );
	            System.out.println( "Last_Name = " + lastName );
	            System.out.println( "E-mail = " + email );

	            System.out.println( "Role Type = " + roleType );
	            System.out.println( "Approved = " + approved );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }
   
   public static void addUser(String email, String password, String first_name, String last_name) {
	      Connection c = null;
	      Statement stmt = null;
	     
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Ahanou",
	            "postgres", "root");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO "+tableName+" (email, password, first_name, last_name) "
	            + "VALUES ('"+email+"','"+password+"', '"+first_name+"', '"+last_name+"');";
	         stmt.executeUpdate(sql);


	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
 }
   
   public static void approveUser(int id) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Ahanou",
	            "postgres", "root");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();

		 	String sql = "UPDATE "+tableName+" SET approved = true WHERE id = "+id+";";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
}
   
   
   public static void viewUserByEmail(String user_email) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Ahanou",
	            "postgres", "root");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();

	         ResultSet rs = stmt.executeQuery( "SELECT * FROM "+tableName+" WHERE email='" + user_email + "';" );
	         while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  firstrName = rs.getString("first_name");
	            String  lastName = rs.getString("last_name");
	            String  email = rs.getString("email");
	            String  roleType = rs.getString("role_type");
             boolean approved = rs.getBoolean("approved");
	            
	            System.out.println( "ID = " + id );
	            System.out.println( "First_Name = " + firstrName );
	            System.out.println( "Last_Name = " + lastName );
	            System.out.println( "E-mail = " + email );

	            System.out.println( "Role Type = " + roleType );
	            System.out.println( "Approved = " + approved );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }
   
   public static void deleteUser(int id) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Ahanou",
	            "postgres", "root");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
			String sql = "DELETE from "+tableName+" where ID = "+id+";";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
  }
   
   
}

