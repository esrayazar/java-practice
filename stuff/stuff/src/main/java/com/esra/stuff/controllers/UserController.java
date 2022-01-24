package com.esra.stuff.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esra.stuff.models.User;
import com.esra.stuff.services.UserService;
import com.esra.stuff.validators.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user,result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newUser = this.userService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/thought/dashboard";
	}
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr) {
		if(!this.userService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User userToBeLoggedIn= this.userService.getUserByEmail(email);
		session.setAttribute("user__id",userToBeLoggedIn.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	

}
