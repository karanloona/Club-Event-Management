package com.cosc.eventclub.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc.eventclub.controller.dao.AddEventDao;
import com.cosc.eventclub.entity.EventsEntity;
import com.cosc.eventclub.service.EventsService;

@RestController
@RequestMapping("/v1")
public class EventsController {

private final EventsService eventsService;
	
	public EventsController(EventsService eventsService) {
		this.eventsService=eventsService;
	}
	
	@PostMapping("/addEvent")
	public EventsEntity addEvent(@RequestBody AddEventDao event) throws Exception {
		
		return eventsService.addEvent(event);
	}
	
	@GetMapping("event/{id}")
	public EventsEntity getEvent(@PathVariable Integer id) throws Exception {
		return eventsService.getEvent(id);
	}
	
	@PutMapping("/updateEvent")
	public EventsEntity updateEvent(@RequestBody EventsEntity event) throws Exception {
		return eventsService.updateEvent(event);
	}
	
	@DeleteMapping("event/{id}")
	public String removeEvent(@PathVariable Integer id) throws Exception {
		return eventsService.removeEvent(id);
	}
	
	
}
