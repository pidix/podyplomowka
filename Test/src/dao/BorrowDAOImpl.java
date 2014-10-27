package dao;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.Book;
import model.Borrow;
import model.BorrowId;
import model.User;

public class BorrowDAOImpl extends GenericDAOImpl<Borrow> implements BorrowDAO {

	private HibernateUtil util;
	BookDAOImpl book = new BookDAOImpl();
	UserDAOImpl user = new UserDAOImpl();

//	@Override
//	public void save(Borrowed entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void update(Borrowed entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void saveorupdate(Borrowed entity) {
//		// TODO Auto-generated method stub
//	
//	}
//
//	@Override
//	public void delete(Borrowed entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Borrowed findById(long id) {
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
//	public List<Borrowed> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Borrow findById(long userId, long bookId) {
		// TODO Auto-generated method stub
		Borrow borrow;
		Session session = util.getSession();
		session.beginTransaction();
		
		User u1 = user.findById(userId);
		Book b1 = book.findById(bookId);
		
		Criteria criteria = session.createCriteria(Borrow.class);
		BorrowId pk = new BorrowId();
		pk.setUser(u1);
		pk.setBook(b1);
		criteria.add(Restrictions.eq("pk", pk));
		borrow = (Borrow) criteria.uniqueResult();
		
		session.close();
		return borrow;
	}

}
