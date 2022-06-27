package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import model.User;

public class UserDao implements Dao<User>{

	@Override
	public Set<User> getAll() {

		    try {
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM "+ User.getTableName());

		        Set<User> users = new HashSet<User>();    //Hashnodes  key value; //list ApiCollection;
		      
		   	 while ( rs.next() ) {
		   		User user = extractUserFromResultSet(rs);
		            users.add(user);
		        }

		       return users;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	


	public User getOne(int id) {
		
		try {
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + User.getTableName() + " WHERE id=" + id); //SQl Injection HQL JPQL

		    while ( rs.next() ) {
				   User user = extractUserFromResultSet(rs);
				   return user;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return null;
	}
	

	public boolean signIn(String email, String password) {
		
		try {
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + User.getTableName() + " WHERE email='" + email + "' AND password='" + password + "' AND role_type='admin' AND approved=true");
		    while ( rs.next() ) {
				   return true;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return false;
	}
		   
		 public User insert(User user)  {
		        System.out.println(user);

			 PreparedStatement stmt;
		    try {
		        stmt = connection.prepareStatement("INSERT INTO " + User.getTableName() + " (email, password, first_name, last_name, approved) VALUES (?, ?, ?, ?, ?) RETURNING *");
		        stmt.setString(1, user.getEmail());
		        stmt.setString(2, user.getPassword());
		        stmt.setString(3, user.getFirst_name());
		        stmt.setString(4, user.getLast_name());
		        stmt.setBoolean(5, user.isApproved());
		        ResultSet rs = stmt.executeQuery();
		        
		        while ( rs.next() ) {
		        	  User user1 = extractUserFromResultSet(rs);
					  return user1;
		          }
   
	
			    stmt.close();
			    connection.close();

		    } catch (SQLException ex) { // not in dao;
		        ex.printStackTrace();
		    }
//		    finally {
//			    stmt.close();
//			    connection.close();
//			}

		    return null;
		    
		}
		    
		 public boolean update(int id, User user) {

			    try {
			        PreparedStatement stmt = connection.prepareStatement("UPDATE " + User.getTableName() + " SET email=?, password=?, first_name=?, last_name=?, approved=?, updated_at=NOW() WHERE id=?");
			        stmt.setString(1, user.getEmail());
			        stmt.setString(2, user.getPassword());
			        stmt.setString(3, user.getFirst_name());
			        stmt.setString(4, user.getLast_name());
			        stmt.setBoolean(5, user.isApproved());
			        stmt.setInt(6, id);

			        int i = stmt.executeUpdate();
			      if(i == 1) {
			  	    return true;
			      }
				    stmt.close();
				    connection.close();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }

			    return false;
			}
		    
		    
		 public boolean delete(int id) {

			    try {
			        Statement stmt = connection.createStatement();
			        int i = stmt.executeUpdate("DELETE FROM " + User.getTableName() + " WHERE id=" + id);

			      if(i == 1) {
			        return true;
			      }
				    stmt.close();
				    connection.close();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    
			    return false;
			}
		 
	
	private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
		  model.User user = new model.User();
		  user.setId( rs.getInt("id") );
		  user.setEmail( rs.getString("email") );
		  user.setPassword( rs.getString("password") );
		  user.setFirst_name( rs.getString("first_name") );
		  user.setLast_name( rs.getString("last_name") );
		  user.setApproved(rs.getBoolean("approved")  );
		  return user;
	}



	public boolean checkEmail(String email) { // move to repository;
		try {
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + User.getTableName() + " WHERE email='" + email + "'");
		    while ( rs.next() ) {
				   return true;
	          }

		} catch (SQLException ex) {
		  //  ex.printStackTrace();
		}

		return false;
	}



}
