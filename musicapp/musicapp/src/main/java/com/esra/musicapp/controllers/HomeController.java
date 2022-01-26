package com.esra.musicapp.controllers;



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

import com.esra.musicapp.models.Album;
import com.esra.musicapp.models.User;
import com.esra.musicapp.services.AlbumService;
import com.esra.musicapp.services.UserService;
import com.esra.stuff.models.Thought;


@RequestMapping("/albums")
@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("/dashboard")
	public String albums(Model model, HttpSession session, @ModelAttribute("album") Album album) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		model.addAttribute("user", user);
		model.addAttribute("allAlbums", this.albumService.allAlbums());
		return "dashboard.jsp";
	}
	
	//create album
	@GetMapping("/dashboard/new")
	public String dashboard(HttpSession session, Model viewModel, @ModelAttribute("album") Album album) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("allalbums", this.albumService.allAlbums());
		return "dashboard.jsp";
	}
	@PostMapping("/dashboard/create")
	public String addAlbum(@Valid @ModelAttribute("album") Album album, BindingResult result, HttpSession session, Model viewModel) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		if(result.hasErrors()) {
			viewModel.addAttribute("user", user);
			viewModel.addAttribute("allAlbums", this.albumService.allAlbums());
			return "new.jsp";
		}
		album.setUser(user);
		 this.albumService.create(album);
		 return "redirect:/albums/dashboard";
	}
//	//Get one album details 
//	@GetMapping("/albums/project/{id}")
//	public String project(@PathVariable("id")Long albumId, Model model,HttpSession session) {
//		Album album = albumService.getOneAlbum(albumId);
//		model.addAttribute("album", album);
//		model.addAttribute("userLoggedIn", (Long)session.getAttribute("userId"));
//	    return "album.jsp";
//		
//	}
//	//Delete
//	@PostMapping("/albums/delete/{id}")
//	private String deleteAlbum(@PathVariable("id")Long albumId,HttpSession session) {
//		albumService.deleteAlbum(albumId);
//		return "redirect:/projects";
//	}
//	
//	//Edit
//	@GetMapping("albums/edit/{id}")
//	public String edit(@PathVariable("id") Long id,@ModelAttribute("editedAlbum") Album album, Model model, HttpSession session) {
//		Album editProject = albumService.getOneAlbum(id);
//		model.addAttribute("editProject", editProject);
//		return "edit.jsp";
//	}
//	
//	//Update
//	@PostMapping("/albums/update/{id}")
//	public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("editedAlbum") Album album, BindingResult result, HttpSession session, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("album",this.albumService.getOneAlbum(id));
//			return "edit.jsp";
//		}
//		this.albumService.updateAlbum(id,album.getAlbumName(), album.getDescription());
//		return "redirect:/albums";
//	}
//	@GetMapping("/{id}/like")
//	public String like(HttpSession session, @PathVariable("id") Long id) {
//		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
//		Album thought = this.albumService.getOneAlbum(id);
//		this.albumService.likeAlbum(user, thought);
//		return "redirect:/thoughts/dashboard";
//	}
	@GetMapping("/{id}/unlike")
	public String unlike(HttpSession session, @PathVariable("id") Long id) {
		User user = this.userService.findOneUser((Long) session.getAttribute("user__id"));
		Album thought = this.albumService.getOneAlbum(id);
		this.albumService.unlikeThought(user, thought);
		return "redirect:/thoughts/dashboard";
	}
//	
//	
	

}
