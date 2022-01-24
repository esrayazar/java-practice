package com.esra.stuff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
//	@PostMapping("/register")
//	public String register(@Valid @ModelAttribute("user") User user, BindingResult result)


}
