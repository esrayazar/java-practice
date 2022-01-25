package com.esra.stuff.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esra.stuff.models.Thought;
import com.esra.stuff.models.User;
import com.esra.stuff.services.ThoughtService;
import com.esra.stuff.services.UserService;

@Controller
@RequestMapping("/thoughts")
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private ThoughtService thoughtService;
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model viewModel, @ModelAttribute("thoughts") Thought thought) {
		User user = this.userService.getOneUser((Long) session.getAttribute("user_id"));
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("allThoughts", this.thoughtService.allthoughts());
		return "dashboard.jsp";
	}

}
