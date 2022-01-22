package com.esra.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esra.albums.models.Song;
import com.esra.albums.services.AlbumService;
import com.esra.albums.services.SongService;

@Controller
@RequestMapping("/song")
public class SongController {
	@Autowired
	private SongService sService;
	@Autowired
	private AlbumService aService;
	
	//localhost:8080/song/new
	@GetMapping("/new")
	public String create(@ModelAttribute("song") Song song, Model viewModel) {
		viewModel.addAttribute("albums", this.aService.getAllAlbums());
		return "/songs/new.jsp";
		
	}
	
	

}
