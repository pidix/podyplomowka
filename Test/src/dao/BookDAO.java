package dao;

import java.util.List;

import model.Book;

public interface BookDAO extends GenericDAO<Book>{

	public List findAllUserById(long id);
}
