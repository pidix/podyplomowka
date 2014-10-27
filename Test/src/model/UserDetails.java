package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "UserDetails")
@SequenceGenerator(name = "seq", sequenceName = "seq_userdetails", allocationSize = 1)
public class UserDetails {

	@Id
	@GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
	@Column(name = "id_userdetails", unique = true)
	private long id;
	@Column(nullable = true)
	private String province;
	@Column(nullable = true)
	private String code;
	@Column(nullable = true)
	private String city;
	@Column(nullable = true)
	private String street;
	@Column(nullable = true)
	private String flat_number;
	@Column(nullable = true)
	private String phone_number;
	@Type(type = "date")
	@Column(nullable = true)
	private Date birth_date;
	@OneToOne
	private User user;
	
	public UserDetails(){
		
	}
	
	public UserDetails(String province, String code, String city, String street, String flat_number, String phone_number, Date birth_date){
		this.province = province;
		this.code = code;
		this.city = city;
		this.street = street;
		this.flat_number = flat_number;
		this.phone_number = phone_number;
		this.birth_date =  birth_date;
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
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the flat_number
	 */
	public String getFlat_number() {
		return flat_number;
	}
	/**
	 * @param flat_number the flat_number to set
	 */
	public void setFlat_number(String flat_number) {
		this.flat_number = flat_number;
	}
	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * @return the birth_date
	 */
	public Date getBirth_date() {
		return birth_date;
	}
	/**
	 * @param birth_date the birth_date to set
	 */
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString(){
		return this.province + " ; " + this.city + " ; " + this.code + " ; " + this.street + " ; " + this.flat_number + " ; " + 
		this.phone_number + " ; " + this.birth_date;
	}
}
