package com.esra.stuff.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String dashboard(HttpSession session, Model viewModel, @ModelAttribute("thought") Thought thought) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("allThoughts", this.thoughtService.allThoughts());
		return "dashboard.jsp";
	}
	@PostMapping("/addThought")
	public String addThought(@Valid @ModelAttribute("thought") Thought thought, BindingResult result, HttpSession session, Model viewModel) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		if(result.hasErrors()) {
			viewModel.addAttribute("user", user);
			viewModel.addAttribute("allThoughts", this.thoughtService.allThoughts());
			return "dashboard.jsp";
		}
		thought.setUser(user);
		 this.thoughtService.create(thought);
		 return "redirect:/thoughts/dashboard";
	}
	@GetMapping("/{id}/like")
	public String like(HttpSession session, @PathVariable("id") Long id) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		Thought thought = this.thoughtService.getOneThought(id);
		this.thoughtService.likeThought(user, thought);
		return "redirect:/throughts/dashboard";
		
		
	}

}
