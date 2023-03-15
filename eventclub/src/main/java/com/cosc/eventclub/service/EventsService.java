package com.cosc.eventclub.service;

import com.cosc.eventclub.controller.dao.AddEventDao;
import com.cosc.eventclub.entity.EventsEntity;

public interface EventsService {
	
	public EventsEntity addEvent(AddEventDao event);

	public EventsEntity getEvent(Integer id);

	public EventsEntity updateEvent(EventsEntity event);

	public String removeEvent(Integer id);

}
