package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import model.Category;


public class CategoryDao implements Dao<Category>{

	@Override
	public Set<Category> getAll() {

		    try {
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM "+ Category.getTableName());

		        Set<Category> categorys = new HashSet<Category>();
		        
		   	 while ( rs.next() ) {
		   		Category category = extractCategoryFromResultSet(rs);
		            categorys.add(category);
		        }

		       return categorys;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	


	public Category getOne(int id) {
		
		try {
		    Statement stmt = connection.createStatement();
		    System.out.print(id);
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + Category.getTableName() + " WHERE id=" + id);

		    while ( rs.next() ) {
				   Category category = extractCategoryFromResultSet(rs);
				   return category;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return null;
	}

		   
		 public Category insert(Category category)  {

		    try {
		        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + Category.getTableName() + " (name, img) VALUES (?, ?) RETURNING *");
		        stmt.setString(1, category.getName());
		        stmt.setString(2, category.getImg());
		        int i = stmt.executeUpdate();

		      if(i == 1) {
		        return category;
		      }
			    stmt.close();
			    connection.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
		}
		    
		 public boolean update(int id, Category category) {

			    try {
			        PreparedStatement stmt = connection.prepareStatement("UPDATE " + Category.getTableName() + " SET name=?, img=?, updated_at=NOW() WHERE id=?");
			        stmt.setString(1, category.getName());
			        stmt.setString(2, category.getImg());
			        stmt.setInt(3, id);

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
			        int i = stmt.executeUpdate("DELETE FROM " + Category.getTableName() + " WHERE id=" + id);

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
		 
	
	private static Category extractCategoryFromResultSet(ResultSet rs) throws SQLException {
		  model.Category category = new model.Category();
		  category.setId( rs.getInt("id") );
		  category.setName( rs.getString("name") );
		  category.setImg( rs.getString("img") );
		  return category;
	}

}
