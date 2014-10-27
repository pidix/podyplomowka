package controler;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.UserDAOImpl;

@ManagedBean
@SessionScoped
public class UserLoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2911695754415080919L;

//	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private UserDAOImpl userImpl = new UserDAOImpl();
	private User user;
	
	private String login;
	private String password;
	private String firstname_name;
	
	
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
	 * @return the firstname_name
	 */
	public String getFirstname_name() {
		return firstname_name;
	}
	/**
	 * @param firstname_name the firstname_name to set
	 */
	public void setFirstname_name(String firstname_name) {
		this.firstname_name = firstname_name;
	}
	public String logowanie(){
		
//		userImpl.setSession(sessionFactory);
		user = userImpl.userFindByLoginPassword(login, password);
		if(user != null){
			setFirstname_name(user.getFirst_name() + " " + user.getName());
			return "success";
		}
		else
			return "false";
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.shtml";
	}
	
}
