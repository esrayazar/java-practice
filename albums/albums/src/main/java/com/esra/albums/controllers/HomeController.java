package com.esra.albums.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esra.albums.models.Album;
import com.esra.albums.services.AlbumService;

@Controller
public class HomeController {
	
	@Autowired
	private AlbumService aService;


	@GetMapping("/")
	public String index(Model viewModel) {
	viewModel.addAttribute( "allAlbums", this.aService.getAllAlbums());
	return "index.jsp";
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
		return "redirect:/";
	}
	
	@PostMapping("/htmladd")
	public String htmlAdd(@RequestParam("albumName") String album, @RequestParam("bandName") String band, @RequestParam("year") Integer year) {
	Album albumToSave = new Album(album, band, year);
	this.aService.createAlbum(albumToSave);
	return "redirect:/";
	}
}