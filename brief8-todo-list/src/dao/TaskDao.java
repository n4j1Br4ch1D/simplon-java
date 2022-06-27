package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import model.Task;
import model.User;

public class TaskDao implements Dao<Task>{

	@Override
	public Set<Task> getAll() {

		    try {
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT *,  categories.name AS category FROM " + Task.getTableName() + " INNER JOIN categories ON tasks.category_id = categories.id;");

		        Set<Task> tasks = new HashSet<Task>();
		        
		   	 while ( rs.next() ) {
		   		Task task = extracttaskFromResultSet(rs);
		            tasks.add(task);
		        }

		       return tasks;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	
	public Set<Task> search(String keyword) {

	    try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("	SELECT *,  categories.name AS category FROM  " + Task.getTableName() + " INNER JOIN categories ON tasks.category_id = categories.id WHERE " + Task.getTableName() + ".name ILIKE '%"+keyword+"%' OR description ILIKE '%"+keyword+"%'");

	        Set<Task> tasks = new HashSet<Task>();
	        
	   	 while ( rs.next() ) {
	   		Task task = extracttaskFromResultSet(rs);
	            tasks.add(task);
	        }

	       return tasks;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
}

	


	
	public Set<Task> getAllByCategory(int catId) {

		    try {
		        Statement stmt = connection.createStatement();
		        
		        ResultSet rs = stmt.executeQuery("SELECT * FROM "+ Task.getTableName() + " WHERE category_id=" + catId);

		        Set<Task> tasks = new HashSet<Task>();
		        
		   	 while ( rs.next() ) {
		   		Task task = extracttaskFromResultSet(rs);
		            tasks.add(task);
		        }

		       return tasks;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	
	
	public Set<Task> getAllByStatus(String status) {

	    try {
	        Statement stmt = connection.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("SELECT *, categories.name AS category FROM "+ Task.getTableName() + " INNER JOIN categories ON tasks.category_id = categories.id WHERE " + Task.getTableName() + ".status='" + status + "'");
	        

	        Set<Task> tasks = new HashSet<Task>();
	        
	   	 while ( rs.next() ) {
	   		Task task = extracttaskFromResultSet(rs);
	            tasks.add(task);
	        }

	       return tasks;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
}
	
	public Set<Task> getAllByCategory(String category) {

	    try {
	        Statement stmt = connection.createStatement();
	        
	        String sql = "SELECT *, categories.name AS category FROM "+ Task.getTableName() + " INNER JOIN categories ON tasks.category_id = categories.id WHERE categories.name='" + category + "'";
	        System.out.println(sql);
	        ResultSet rs = stmt.executeQuery(sql);
	        

	        Set<Task> tasks = new HashSet<Task>();
	        
	   	 while ( rs.next() ) {
	   		Task task = extracttaskFromResultSet(rs);
	            tasks.add(task);
	        }

	       return tasks;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
}

	public Task getOne(int id) {
		
		try {
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + Task.getTableName() + " WHERE id=" + id);

		    while ( rs.next() ) {
				   Task task = extracttaskFromResultSet(rs);
				   return task;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return null;
	}
		   
		 public Task insert(Task task)  {

		    try {

              PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + Task.getTableName() + " (name, description, status, tobefinished_at, finished_at, category_id) VALUES (?, ?, ?, ?::Date, ?::Date, ?) RETURNING *, tasks.category_id as category;");

		        stmt.setString(1, task.getName());
		        stmt.setString(2, task.getDescription());
		        stmt.setString(3, task.getStatus());
		        stmt.setString(4, task.getTobefinished_at());
		        stmt.setString(5, task.getFinished_at());
		        stmt.setInt(6, task.getCategory_id());
		        
		        ResultSet rs = stmt.executeQuery();
		        
		        while ( rs.next() ) {
		        	  Task task1 = extracttaskFromResultSet(rs);
					  return task1;
		          }


			    stmt.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
		}

		public boolean update(int id, Task task) {

			    try {
			        PreparedStatement stmt = connection.prepareStatement("UPDATE " + Task.getTableName() + " SET name=?, description=?, status=?, tobefinished_at=?, finished_at=?, category_id=?, updated_at=NOW() WHERE id=?");
			        stmt.setString(1, task.getName());
			        stmt.setString(2, task.getDescription());
			        stmt.setString(3, task.getStatus());
			        stmt.setString(4, task.getTobefinished_at());
			        stmt.setString(5, task.getFinished_at());
			        stmt.setInt(6, task.getCategory_id());
			        stmt.setInt(7, id);

			        int i = stmt.executeUpdate();
			      if(i == 1) {
			  	    return true;
			      }
				    stmt.close();
//				    connection.close();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }

			    return false;
			}
		
		public boolean setStatus(int id, String status) {

		    try {
		        PreparedStatement stmt = connection.prepareStatement("UPDATE " + Task.getTableName() + " SET status=?, updated_at=NOW() WHERE id=?");
		        stmt.setString(1, status);
		        stmt.setInt(2, id);

		        int i = stmt.executeUpdate();
		      if(i == 1) {
		  	    return true;
		      }
			    stmt.close();
//			    connection.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return false;
		}
		    
		    
		 public boolean delete(int id) {

			    try {
			        Statement stmt = connection.createStatement();
			        int i = stmt.executeUpdate("DELETE FROM " + Task.getTableName() + " WHERE id=" + id);

			      if(i == 1) {
			        return true;
			      }
				    stmt.close();
//				    connection.close();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    
			    return false;
			}
		 
	
	private static Task extracttaskFromResultSet(ResultSet rs) throws SQLException {
		  model.Task task = new model.Task();
		  
		  task.setId( rs.getInt("id") );
		  task.setName( rs.getString("name") );
		  task.setDescription( rs.getString("description") );
		  task.setStatus( rs.getString("status") );
		  task.setCreated_at(rs.getString("created_at") );
		  task.setTobefinished_at(rs.getString("tobefinished_at") );
		  task.setFinished_at(rs.getString("finished_at") );
		  task.setCategory(rs.getString("category"));
		  task.setCategory_id(rs.getInt("category_id") );
		  return task;
	}

}
