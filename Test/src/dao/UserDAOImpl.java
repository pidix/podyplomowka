package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import model.Book;
import model.Borrow;
import model.User;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {
	
	private HibernateUtil util;
	
//	@Override
//	public void save(User entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void update(User entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void saveorupdate(User entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(User entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public User findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean exists(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<User> findall() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<User> userFindByName(String name) {
		// TODO Auto-generated method stub
		List<User> list;
//		Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("name", name));
		list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public List<User> userFindByFirstnameName(String first_name, String name) {
		// TODO Auto-generated method stub
		List<User> list;
//		Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.and(Restrictions.like("first_name", first_name),Restrictions.like("name", name)));
		list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public User userFindByLoginPassword(String login, String password) {
		// TODO Auto-generated method stub
		User user;
//		Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.and(Restrictions.like("login", login),Restrictions.like("password", password)));
		user = (User) criteria.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User userFindByLogin(String login) {
		// TODO Auto-generated method stub
		User user;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("login", login));
		user = (User)criteria.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public List<Book> findAllBookById(long id) {
		// TODO Auto-generated method stub
		
		List<Book> listBook = new ArrayList<Book>();
		List<Borrow> listBorrow;
		List<User> listUser;
		
		Iterator<User> iteratorUser;
		Iterator<Borrow> iteratorBorrow;
		
		Session session = util.getSession();
		session.beginTransaction();
		Criteria criterial = session.createCriteria(User.class).add(Restrictions.eq("id", id));
		listUser = criterial.list();
		
		iteratorUser = listUser.iterator();
		while(iteratorUser.hasNext()){
			listBorrow = iteratorUser.next().getBorrow();
			iteratorBorrow = listBorrow.iterator();
			while(iteratorBorrow.hasNext()){
				listBook.add(iteratorBorrow.next().getBook());
			}
		}
		
		return listBook;
	}

}
