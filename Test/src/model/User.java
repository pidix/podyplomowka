package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Users")
@SequenceGenerator(name="seq",sequenceName="seq_user", allocationSize = 1)
public class User{

	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@Column(name = "id_user", unique = true)
	private long id;
	@Column(nullable = false, length = 15)
	private String first_name;
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 50)
	private String e_mail;
	@Column(nullable = false, unique = true, length = 100)
	private String login;
	@Column(nullable = false, length = 100)
	private String password;
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	UserDetails userDetails;
	@OneToMany(mappedBy = "pk.user", fetch = FetchType.LAZY)
	private List<Borrow> borrow;
	
	public User(){
		
	}
	
	public User(String first_name, String name, String e_mail, String login, String password){
		this.id = id;
		this.first_name = first_name;
		this.name = name;
		this.e_mail = e_mail;
		this.login = login;
		this.password = password;
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
	 * @return the e_mail
	 */
	public String getE_mail() {
		return e_mail;
	}

	/**
	 * @param e_mail the e_mail to set
	 */
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
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
	public void setBorrowed(List<Borrow> borrow) {
		this.borrow = borrow;
	}

	public String toString(){
		return getId() + " ; " + getFirst_name() + " ; " + getName() + " ; " + getE_mail() + " ; " + getLogin() + " ; " + getPassword();
	}
	
}
