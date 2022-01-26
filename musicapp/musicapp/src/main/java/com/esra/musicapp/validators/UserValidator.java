package com.esra.musicapp.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.esra.musicapp.models.User;
import com.esra.musicapp.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user =(User) target;
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Password do not match!!!!!!!!");
		}
		if (this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email has already taken");
		}
		if (user.getFirstName().equals("reena")) {
			errors.rejectValue("firstName", "noMattAllowed", "Reena s  are unable to register at this time :)");
		}
		
	}

}

