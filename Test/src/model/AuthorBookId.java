package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class AuthorBookId implements Serializable{

	private Book book;
	private Author author;
	
	/**
	 * @return the author
	 */
	@ManyToOne
	public Author getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
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
	
//	public boolean equals(Object o){
//		if(this == o)
//			return true;
//		if(o == null || getClass() != o.getClass())
//			return false;
//		
//		AuthorBookId that = (AuthorBookId) o;
//		
//		if(author != null ? !author.equals(that.author) : that.author != null) 
//			return false;
//		if(book != null ? !book.equals(that.book) : that.book != null)
//			return false;
//		return true;	
//	}
}
