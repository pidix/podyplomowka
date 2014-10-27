package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
@SequenceGenerator(name = "seq", sequenceName = "seq_book", allocationSize = 1)
public class Book {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_book", nullable = false, unique = true)
	private Long id;
	@Column(length = 255, nullable = false)
	private String title;
	@Column(length = 255, nullable = false)
	private String describe;
	@Column(name = "ISBN", columnDefinition = "decimal(13,0)", nullable = false)
	private long isbn;
	@Column(name = "count", nullable = false)
	private int count;
	@Column(nullable = false)
	private boolean active;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "pk.book", fetch = FetchType.LAZY)
	private List<Borrow> borrow;
	
	
	public Book(){
		
	}
	
	public Book(String title, String describe, int count, long ISBN, boolean status){
		
		this.id = id;
		this.title = title;
		this.describe = describe;
		this.active = status;
		this.count = count;
		this.isbn = ISBN;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * @param describe the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * @return the borrowed
	 */
	public List<Borrow> getBorrow() {
		return borrow;
	}

	/**
	 * @param borrowed the borrowed to set
	 */
	public void setBorrow(List<Borrow> borrow) {
		this.borrow = borrow;
	}

	public String toString(){
		return getId() + " ; " + getTitle() + " ; " + getDescribe() + " ; " + getCount() + " ; " +
				getIsbn() + " ; " + getCategory();
	}
}
