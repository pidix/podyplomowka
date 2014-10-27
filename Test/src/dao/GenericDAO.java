/**
 * 
 */
package dao;

import java.util.List;

/**
 * @author Kwiatkowski
 *
 */
public interface GenericDAO<T> {
	
	public void save(T entity);
	public void update(T entity);
	public void saveorupdate(T entity);
	public void delete(T entity);
	public T findById(long id);
	public boolean exists(long id);
	public List<T> findAll();
}
