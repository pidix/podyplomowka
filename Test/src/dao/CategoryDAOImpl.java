package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import service.Tools;
import model.Book;
import model.Category;

public class CategoryDAOImpl extends GenericDAOImpl<Category> implements CategoryDAO {

	HibernateUtil util = new HibernateUtil();
	
//	@Override
//	public void save(Category entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void update(Category entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void saveorupdate(Category entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Category entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Category findById(long id) {
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
//	public List<Category> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		
		Category category;
		
		Session session = util.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.like("name", name));
		category = (Category) criteria.uniqueResult();
		session.close();
		
		return category;
	}

	@Override
	public List<Book> findListBookByCategory(String name) {
		// TODO Auto-generated method stub
		List<Book> listBook;
		Category category;
		
		Session session = util.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.like("name", name)); 
		category = (Category) criteria.uniqueResult();
		listBook = category.getListBook();		
		
		return listBook;
	}


}
