package dao;
import java.sql.Connection;
import java.util.Set;  // CTRl +shift  + o;

import helper.DBConnection;

public interface Dao<T> {
	  Connection connection = DBConnection.getConnection(); //static   => Interface attributes are by default public , static and final.
	  Set<T> getAll();
	  T getOne(int id);
	  T insert(T item);
	  boolean update(int id, T item);
	  boolean delete(int id);   
	  
}
