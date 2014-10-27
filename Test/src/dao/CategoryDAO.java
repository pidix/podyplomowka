package dao;

import java.util.List;

import model.Book;
import model.Category;

public interface CategoryDAO extends GenericDAO<Category>{

	public Category findByName(String name);
	public List<Book> findListBookByCategory(String name);
}
