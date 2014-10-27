package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.Restrictions;

import model.Book;
import model.Borrow;
import model.User;

public class BookDAOImpl extends GenericDAOImpl<Book> implements BookDAO {

	private HibernateUtil util;
	
//	@Override
//	public void save(Book entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void update(Book entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void saveorupdate(Book entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Book entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Book findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean exists(long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Book> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public List findAllUserById(long id) {
		// TODO Auto-generated method stub
		
		List<Book> listBook;
		List<Borrow> listBorrow;
		List<User> listUser = new ArrayList<User>();
		
		Iterator<Book> iteratorBook;
		Iterator<Borrow> iteratorBorrow;
		
		Session session = util.getSession();
		session.beginTransaction();
		Criteria critteria = session.createCriteria(Book.class).add(Restrictions.eq("id", id));
		listBook = critteria.list();
		
		iteratorBook = listBook.iterator();
		
		while(iteratorBook.hasNext()){
			listBorrow = iteratorBook.next().getBorrow();
			iteratorBorrow = listBorrow.iterator();
			while(iteratorBorrow.hasNext()){
				listUser.add(iteratorBorrow.next().getUser());
			}
		}
		
		session.close();
		return listUser;
	}

}
