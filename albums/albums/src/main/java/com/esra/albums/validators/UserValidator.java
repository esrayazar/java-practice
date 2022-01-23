package com.esra.albums.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.esra.albums.models.User;
import com.esra.albums.repositories.UserRepository;

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
		if (user.getFirstName().equals("Esra")) {
			errors.rejectValue("firstName", "noMattAllowed", "Esra s  are unable to register at this time");
		}
		
	}

}
