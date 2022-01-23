package com.esra.albums.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esra.albums.models.Album;
import com.esra.albums.models.User;
import com.esra.albums.services.AlbumService;
import com.esra.albums.services.UserService;
import com.esra.albums.validators.UserValidator;

@Controller
public class HomeController {
	
	@Autowired
	private AlbumService aService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;

	
	@GetMapping("/")
	public String landing(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	@PostMapping("/registerUser")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user,result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User userToBeLoggedIn= this.uService.getUserByEmail(email);
		session.setAttribute("user__id",userToBeLoggedIn.getId());
		return "redirect:/dashboard";
	}
	

	@GetMapping("/dashboard")
	public String index(Model viewModel,HttpSession session) {
	if(session.getAttribute("user__id")==null) {
		System.out.println("---> redirect");
		return "redirect:/";
	}
	System.out.println("user -->"+session.getAttribute("user__id"));
	viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id" )));
	viewModel.addAttribute( "allAlbums", this.aService.getAllAlbums());
	return "index.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User userToLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id" ));
		Album albumToLike = this.aService.getOneAlbum(id);
		this.aService.likeAlbum(userToLikeAlbum, albumToLike);
		return "redirect:/dashboard";
	}
	@GetMapping("/unlike/{id}")
	public String unLike(@PathVariable("id") Long id, HttpSession session) {
		User userToLikeAlbum = this.uService.getOneUser((Long)session.getAttribute("user__id" ));
		Album albumTounlike = this.aService.getOneAlbum(id);
		this.aService.unLikeAlbum(userToLikeAlbum, albumTounlike);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/new")
	public String add(@ModelAttribute("album") Album album) {
		return "add.jsp";
	}
	@PostMapping("/new")
	public String addRecord(@Valid @ModelAttribute("album") Album album, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.aService.createAlbum(album);
		return "redirect:/dashboard";
	}
	@GetMapping("/edit/{id}")
	public String editRecord(@PathVariable("id") Long id, @ModelAttribute("album") Album album, Model viewModel) {
		viewModel.addAttribute("album",this.aService.getOneAlbum(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("album") Album album, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("album",this.aService.getOneAlbum(id));
			return "edit.jsp";
		}
		this.aService.editAlbum(album);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/details/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
	viewModel.addAttribute("albumDetails", this.aService.getOneAlbum(id));
	return "show.jsp";
	
	}
	
	@PostMapping("/htmladd")
	public String htmlAdd(@RequestParam("albumName") String album, @RequestParam("bandName") String band, @RequestParam("year") Integer year) {
	Album albumToSave = new Album(album, band, year);
	this.aService.createAlbum(albumToSave);
	return "redirect:/dashboard";
	}
}