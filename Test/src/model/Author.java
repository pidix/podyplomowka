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
@Table(name = "Authors")
@SequenceGenerator(name = "seq", sequenceName = "seq_author", allocationSize = 1)
public class Author {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@Column(name = "id_author", unique = true)
	private Long id;
	@Column(length = 50, nullable = false)
	private String first_name;
	@Column(length = 50, nullable = false)
	private String name;
	@OneToMany(mappedBy = "pk.author", fetch = FetchType.LAZY)
	private List<AuthorBook> authorBook;
	
	
	public Author(){
		
	}
	
	public Author(String first_name, String name){
		
		this.first_name = first_name;
		this.name = name;
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	 * @return the authorBook
	 */
	public List<AuthorBook> getAuthorBook() {
		return authorBook;
	}
	/**
	 * @param authorBook the authorBook to set
	 */
	public void setAuthorBook(List<AuthorBook> authorBook) {
		this.authorBook = authorBook;
	}
	
	public String toString(){
		return getId() + " ; " + getFirst_name() + " ; " + getName();
	}
}
