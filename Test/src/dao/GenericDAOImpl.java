package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
	
	private Class<T> type;
	private List<T> list;
	private HibernateUtil util;
	
	public GenericDAOImpl(){
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		util = new HibernateUtil();
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		session.save(entity);
		session.flush();
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void saveorupdate(T entity) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public boolean exists(long id) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		T obj = (T) session.get(type, id);
		session.close();
		if(obj == null)
			return false;
		else
			return true;
	}	
	
	@Override
	public T findById(long id) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		T obj = (T) session.get(type, id);
		session.getTransaction().commit();
		session.close();
		return obj;
	}
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		List<T> list;
//		Session session = sessionFactory.openSession();
		Session session = util.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(type);
		list = criteria.list();
		session.close();
		return list;
	}

}
