package com.esra.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
}