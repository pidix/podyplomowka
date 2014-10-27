package test;

import java.util.List;

import model.Author;
import model.AuthorBook;
import model.Book;
import model.Borrow;
import model.Category;
import model.User;
import model.UserDetails;
import service.Tools;
import dao.AuthorBookDAOImp;
import dao.AuthorDAOImpl;
import dao.BookDAOImpl;
import dao.BorrowDAOImpl;
import dao.BorrowDAOImpl;
import dao.CategoryDAOImpl;
import dao.UserDAOImpl;
import dao.UserDetailsDAOImpl;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tools tools = new Tools();
		UserDAOImpl user = new UserDAOImpl();
		UserDetailsDAOImpl details = new UserDetailsDAOImpl();
		BookDAOImpl book = new BookDAOImpl();
		AuthorDAOImpl author = new AuthorDAOImpl();
		AuthorBookDAOImp authorBook = new AuthorBookDAOImp();
		CategoryDAOImpl category = new CategoryDAOImpl();
		BorrowDAOImpl borrowed = new BorrowDAOImpl();
		
//		long test = 1111111111l;
		
////	ADD USER
//		User u1 = new User("radek", "mazowiecki", "rade@radek.pl",
//				"radzio", "12345");
//		UserDetails ud1 = new UserDetails("³ódzkie", "95-035", "³ódŸ", 
//				"Brzoskwiniowa", "4", "123456789", tools.getDate("1990-08-14"));
//		user.save(u1); 
//		ud1.setUser(u1);
//		details.save(ud1);
//		
//		Category
//		Category c1 = new Category("historyczne");
//		category.save(c1);
//		Category c1 = category.findById(1);
//		
//		ADD BOOK
//		Book b1 = new Book("Krzy¿acy", "powieœæ historyczna", 10, 124214, true);
//		b1.setCategory(c1);
//		book.save(b1);
//		
////		ADD AUTHOR
//		Author a1 = new Author("Henryk", "Sienkiewicz");
//		author.save(a1);
//		Author a1 = author.findById(1);
//		
//		ADD AUTHOR-BOOK
//		Book b1 = book.findById(1);
//		Author a1 = author.findById(1);
//		AuthorBook ab1 = new AuthorBook(b1,a1);
//		authorBook.save(ab1);	
		
////		BORROWED
//		User u1 = user.findById(1);
//		Book b1 = book.findById(1);
//		Borrow w = new Borrow(b1, u1);
//		borrowed.save(w);
		
//		BORROWED TEST
//		List<User> listUser;
		
		
////		BORROWED UPDATE
//		Borrowed w = null;
//		w = borrowed.findById(1, 1);
//		w.setExtend(true);
//		w.setDate(new Tools().getTime());
//		borrowed.saveorupdate(w);
	}
}
