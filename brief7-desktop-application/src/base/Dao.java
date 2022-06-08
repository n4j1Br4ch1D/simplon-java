package base;
import java.sql.Connection;
import java.util.Set;

import entity.User;

public interface Dao<T> {
	  Connection connection = DBConnection.getConnection();
	  Set<T> getAll();
	  T getOne(int id);
	  boolean insert(T item);
	  boolean update(int id, T item);
	  boolean delete(int id);
}