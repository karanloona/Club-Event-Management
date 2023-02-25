package com.cosc.eventclub.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc.eventclub.entity.ClubEntity;
import com.cosc.eventclub.service.ClubsService;

@RestController
@RequestMapping("/v1")
public class ClubsController {
	
	private final ClubsService clubsService;
	
	public ClubsController(ClubsService clubsService) {
		this.clubsService=clubsService;
	}
	
	@PostMapping("/addClub")
	public ClubEntity addClub(@RequestBody ClubEntity club) throws Exception {
		
		return clubsService.addClub(club);
	}
	
	@GetMapping("club/{id}")
	public ClubEntity getClub(@PathVariable Integer id) throws Exception {
		return clubsService.getClub(id);
	}
	
	@PutMapping("/updateClub")
	public ClubEntity updateClub(@RequestBody ClubEntity club) throws Exception {
		return clubsService.updateClub(club);
	}
	
	@DeleteMapping("club/{id}")
	public String removeClub(@PathVariable Integer id) throws Exception {
		return clubsService.removeClub(id);
	}

}
