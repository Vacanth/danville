package com.webapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webapp.datamodel.SignInModel;

//TODO This validator is not properly configured. 
//Control wont come to this validator with current implementation.
public class SignInValidator implements Validator {

	public boolean supports(Class clazz) {
		return SignInModel.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		SignInModel login = (SignInModel) obj;
		if (login.getUsername() == null || login.getUsername().length() == 0) {
			errors.rejectValue("username", "error.empty.field",
					"Please Enter User Name");
		} else if (!login.getUsername().equals("admin")) {
			errors.rejectValue("username", "unknown.user", "Unknown User");
		}
		if (login.getPassword() == null || login.getPassword().length() == 0) {
			errors.rejectValue("password", "error.empty.field",
					"Please Enter Password");
		} else if (!login.getPassword().equals("admin")) {
			errors.rejectValue("password", "wrong.password", "Wrong Password");
		}
	}
}
