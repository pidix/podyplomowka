package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AuthorBook")
public class AuthorBook {

	private AuthorBookId pk = new AuthorBookId();

	public AuthorBook(){
		
	}
	
	public AuthorBook(Book book, Author author){
		getPk().setBook(book);
		getPk().setAuthor(author);
	}

	/**
	 * @return the pk
	 */
	@EmbeddedId
	public AuthorBookId getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(AuthorBookId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Author getAuthor(){
		return getPk().getAuthor();
	}
	
	public void setAuthor(Author author){
		getPk().setAuthor(author);
	}
	
	@Transient
	public Book getBook(){
		return getPk().getBook();
	}
	
	public void setBook(Book book){
		getPk().setBook(book);
	}
	
	public String toString(){
		return getAuthor().getId() + " ; " +getAuthor().getFirst_name() + " ; " + getAuthor().getName() +
				" ; " + getBook().getId() + " ; " + getBook().getTitle() + " ; " + getBook().getDescribe();
	}
	
}
