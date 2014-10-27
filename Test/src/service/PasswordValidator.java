package service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		
		if(arg2 == null)
			throw new ValidatorException(new FacesMessage("Pole jest wymagane"));
		
		String passwordId = (String)arg1.getAttributes().get("passwordID");
		UIInput passwordInput = (UIInput)arg0.getViewRoot().findComponent(passwordId);
		
		String password = (String)passwordInput.getValue();
		String confirm = (String) arg2;
		
		if(!password.equals(confirm))
			throw new ValidatorException(new FacesMessage("Has³a nie sa identyczne"));
	}

}
