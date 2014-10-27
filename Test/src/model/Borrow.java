package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import service.Tools;

@Entity
@Table(name = "borrow")
@SequenceGenerator(name = "seq", sequenceName = "seq_borrowed", allocationSize = 1)
public class Borrow {

	private BorrowId pk = new BorrowId();
	private Date date;
	@Column(columnDefinition = "boolean default false")
	private boolean extend;
	@Column(name = "status", columnDefinition = "boolean default true")
	private boolean status;
	
	public Borrow(){
		
	}
	
	public Borrow(Book book, User user){
		this.date = new Tools().getTime();
		getPk().setBook(book);
		getPk().setUser(user);
	}
	
	public Borrow(Book book, User user, boolean status){
		this.date = new Tools().getTime();
		this.status = status;
		getPk().setBook(book);
		getPk().setUser(user);
	}
	
	public Borrow(Book book, User user, boolean status, boolean extend){
		this.date = new Tools().getTime();
		this.status = status;
		this.extend = extend;
		getPk().setBook(book);
		getPk().setUser(user);
	}

	/**
	 * @return the pk
	 */
	@EmbeddedId
	public BorrowId getPk() {
		return pk;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(BorrowId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Book getBook(){
		return getPk().getBook();
	}
	
	public void setBook(Book book){
		getPk().setBook(book);
	}
	
	@Transient
	public User getUser(){
		return getPk().getUser();
	}
	
	public void setUser(User user){
		getPk().setUser(user);
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the extend
	 */
	public boolean isExtend() {
		return extend;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @param extend the extend to set
	 */
	public void setExtend(boolean extend) {
		this.extend = extend;
	}
}
