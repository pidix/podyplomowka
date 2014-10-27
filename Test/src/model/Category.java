package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@SequenceGenerator(name = "seq", sequenceName = "seq_category", allocationSize = 1)
public class Category {

	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", unique = true)
	private long id;
	@Column(length = 255, nullable = false)
	private String name;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Book> listBook;
	
	public Category(){
		
	}
	
	public Category(String name){
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the listBook
	 */
	public List<Book> getListBook() {
		return listBook;
	}
	/**
	 * @param listBook the listBook to set
	 */
	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}
}
