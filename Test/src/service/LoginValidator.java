package service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import model.User;
import dao.UserDAOImpl;

public class LoginValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		
		if(arg2 == null)
			throw new ValidatorException(new FacesMessage("Pole jest wymagane"));
		
		String login = (String)arg2;
		
		UserDAOImpl userImpl = new UserDAOImpl();
		User user = userImpl.userFindByLogin(login);
		if(user != null)
			throw new ValidatorException(new FacesMessage("Podany login ju¿ istnieje"));
	}

}
