package com.esra.stuff.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esra.stuff.models.User;
import com.esra.stuff.services.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session)}
		validator.validate(user,result);
	if(result.hasErrors()) {
		return "landing.jsp";
	}
	User newUser = this.uService.registerUser(user);
	session.setAttribute("user__id", newUser.getId());
	return "redirect:/dashboard";
}
	


}
