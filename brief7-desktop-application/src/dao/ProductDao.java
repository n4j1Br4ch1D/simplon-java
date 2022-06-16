package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import model.Product;
import model.User;

public class ProductDao implements Dao<Product>{

	@Override
	public Set<Product> getAll() {

		    try {
		        Statement stmt = connection.createStatement();
//		        ResultSet rs = stmt.executeQuery("SELECT * FROM "+ Product.getTableName());
		        ResultSet rs = stmt.executeQuery("SELECT *,  categories.name AS category FROM " + Product.getTableName() + " INNER JOIN categories ON products.category_id = categories.id;");


		        Set<Product> products = new HashSet<Product>();
		        
		   	 while ( rs.next() ) {
		   		Product product = extractProductFromResultSet(rs);
		            products.add(product);
		        }

		       return products;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	
	public Set<Product> search(String keyword) {

	    try {
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("	SELECT *,  categories.name AS category FROM  " + Product.getTableName() + " INNER JOIN categories ON products.category_id = categories.id WHERE " + Product.getTableName() + ".name ILIKE '%"+keyword+"%' OR description ILIKE '%"+keyword+"%'");

	        Set<Product> products = new HashSet<Product>();
	        
	   	 while ( rs.next() ) {
	   		Product product = extractProductFromResultSet(rs);
	            products.add(product);
	        }

	       return products;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
}

	


	
	public Set<Product> getAllByCategory(int catId) {

		    try {
		        Statement stmt = connection.createStatement();
		        
		        ResultSet rs = stmt.executeQuery("SELECT * FROM "+ Product.getTableName() + " WHERE category_id=" + catId);

		        Set<Product> products = new HashSet<Product>();
		        
		   	 while ( rs.next() ) {
		   		Product product = extractProductFromResultSet(rs);
		            products.add(product);
		        }

		       return products;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	

	public Product getOne(int id) {
		
		try {
		    Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + Product.getTableName() + " WHERE id=" + id);

		    while ( rs.next() ) {
				   Product product = extractProductFromResultSet(rs);
				   return product;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return null;
	}
		   
		 public Product insert(Product product)  {

		    try {
//			    Statement stmt = connection.createStatement();
//                 String sql = "INSERT INTO " + Product.getTableName() + " (name, img, description, price, unit, city, category_id) VALUES ('"+product.getName()+"', '"+product.getImg()+"', '"+product.getDescription()+"', "+product.getPrice()+ ", '"+product.getUnit()+"', '"+product.getCity()+"', "+product.getCategory_id()+"); SELECT * , categories.name AS category FROM " + Product.getTableName() +" INNER JOIN categories ON products.category_id = categories.id WHERE products.name = 'Orange';";
//		  System.out.println(sql);   
//			    ResultSet rs = stmt.executeQuery(sql);

//	              PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + Product.getTableName() + " (name, img, description, price, unit, city, category_id) VALUES (?, ?, ?, ?, ?, ?, ?); SELECT * , categories.name AS category FROM " + Product.getTableName() +" INNER JOIN categories ON products.category_id = categories.id WHERE products.name = 'Orange';");

              PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + Product.getTableName() + " (name, img, description, price, unit, city, category_id) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING *, products.category_id as category;");

		        stmt.setString(1, product.getName());
		        stmt.setString(2, product.getImg());
		        stmt.setString(3, product.getDescription());
		        stmt.setFloat(4, product.getPrice());
		        stmt.setString(5, product.getUnit());
		        stmt.setString(6, product.getCity());
		        stmt.setInt(7, product.getCategory_id());
//		        stmt.setString(8, product.getName());
		        
		        ResultSet rs = stmt.executeQuery();
		        
		        while ( rs.next() ) {
		        	  Product Product = extractProductFromResultSet(rs);
					  return Product;
		          }


			    stmt.close();
//			    connection.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
		}

		public boolean update(int id, Product product) {

			    try {
			        PreparedStatement stmt = connection.prepareStatement("UPDATE " + Product.getTableName() + " SET name=?, img=?, description=?, price=?, unit=?, city=?, category_id=?, updated_at=NOW() WHERE id=?");
			        stmt.setString(1, product.getName());
			        stmt.setString(2, product.getImg());
			        stmt.setString(3, product.getDescription());
			        stmt.setFloat(4, product.getPrice());
			        stmt.setString(5, product.getUnit());
			        stmt.setString(6, product.getCity());
			        stmt.setInt(7, product.getCategory_id());
			        stmt.setInt(8, id);

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
			        int i = stmt.executeUpdate("DELETE FROM " + Product.getTableName() + " WHERE id=" + id);

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
		 
	
	private static Product extractProductFromResultSet(ResultSet rs) throws SQLException {
		  model.Product product = new model.Product();
		  product.setId( rs.getInt("id") );
		  product.setName( rs.getString("name") );
		  product.setImg( rs.getString("img") );
		  product.setDescription( rs.getString("description") );
		  product.setPrice( rs.getFloat("price") );
		  product.setUnit(rs.getString("unit") );
		  product.setCity(rs.getString("city") );
		  product.setCategory(rs.getString("category"));
		  product.setCategory_id(rs.getInt("category_id") );
		  return product;
	}

}
