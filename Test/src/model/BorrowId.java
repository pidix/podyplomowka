package model;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class BorrowId implements Serializable{

	private Book book;
	private User user;
	
	/**
	 * @return the book
	 */
	@ManyToOne
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
