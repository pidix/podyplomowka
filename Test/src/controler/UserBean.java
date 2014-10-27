package controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import model.User;
import dao.UserDAOImpl;

import javax.validation.constraints.NotNull;

@ManagedBean
//@SessionScoped
@RequestScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7114401268986591329L;

//	SessionFactory sessionFactory = new Configuration().configure()
//			.buildSessionFactory();
	private UserDAOImpl userImpl;
	private User user;

	private long id;
	private String login;
	private String password;
	private String confirm_password;
	private String first_name;
	private String name;
	private String e_mail;

	public UserBean(){
		
	}
	
	private void clearBean(){
		this.login = null;
		this.first_name = null;
		this.name = null;
		this.password = null;
		this.confirm_password = null;
		this.e_mail = null;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return first_name;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return e_mail;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String e_mail) {
		this.e_mail = e_mail;
	}

	/**
	 * @return the confirm_password
	 */
	public String getConfirm_password() {
		return confirm_password;
	}

	/**
	 * @param confirm_password the confirm_password to set
	 */
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public List<User> getUsers() {
		
		userImpl = new UserDAOImpl();
//		userImpl.setSession(sessionFactory);
		return userImpl.findAll();
	}

	public String delete() {
		
		userImpl.delete(user);
		return null;
	}

	public String edit() {
		
		User s1 = userImpl.findById(user.getId());
		setId(s1.getId());
		setLogin(s1.getLogin());
		setFirstname(s1.getFirst_name());
		setName(s1.getName());
		setEmail(s1.getE_mail());
		return "/user_edit.xhtml";
	}

	public String addUser() {

		userImpl = new UserDAOImpl();
		user = new User(this.first_name, this.name, this.e_mail, this.login,this.password);
		userImpl.save(user);
		return "success";
	}
	
	public String saveUser(){

		userImpl = new UserDAOImpl();
		User s1 = userImpl.findById(id);
		s1.setFirst_name(first_name);
		s1.setName(name);
		s1.setPassword(password);
		s1.setE_mail(e_mail);
		userImpl.saveorupdate(s1);
		return "success";
	}
	
	public String goStartPage(){

//		System.out.println(id);
//		System.out.println(password);
//		System.out.println(confirm_password);
//		System.out.println(name);
		return "success";
	}
}
