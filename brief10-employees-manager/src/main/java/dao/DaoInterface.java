package dao;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T> {

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(int id);
	
	public void delete(int id);
	
	public List<T> findAll();
		
}
