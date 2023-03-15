package com.cosc.eventclub.service.impl;

import java.util.Date;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.cosc.eventclub.controller.dao.AddEventDao;
import com.cosc.eventclub.entity.ClubEntity;
import com.cosc.eventclub.entity.EventsEntity;
import com.cosc.eventclub.repository.ClubsRepository;
import com.cosc.eventclub.repository.EventsRepository;
import com.cosc.eventclub.repository.UsersRepository;
import com.cosc.eventclub.service.EventsService;


@Service
public class EventsServiceImpl implements EventsService {
	

	private final EventsRepository eventsRepository;
	
	private final ClubsRepository clubsRepository;
	
	private final UsersRepository usersRepo;

	public EventsServiceImpl(EventsRepository eventsRepository, ClubsRepository clubsRepository, UsersRepository usersRepo) {
		this.eventsRepository = eventsRepository;
		this.clubsRepository=clubsRepository;
		this.usersRepo=usersRepo;
	}

	@Override
	public EventsEntity addEvent(AddEventDao event) {
		EventsEntity entity=new EventsEntity();
		entity.setEventName(event.getEventName());
		entity.setEventPrice(event.getEventPrice());
		entity.setDateAdded(new Date());
		ClubEntity club=clubsRepository.findById(event.getClubId()).get();
		if(club!=null) {
		entity.setClub(club);
		return eventsRepository.save(entity);
		}else {
		return null;
		}
	}

	@Override
	public EventsEntity getEvent(Integer id) {
		
		return eventsRepository.findById(id).get();
	}

	@Override
	public EventsEntity updateEvent(EventsEntity event) {
		if(eventsRepository.findById(event.getEventId()).equals(null)) {
		EventsEntity entity=new EventsEntity();
		entity.setEventName(event.getEventName());
		entity.setEventPrice(event.getEventPrice());
		entity.setDateAdded(new Date());
		HashSet<Integer> userSet= new HashSet<Integer>();
		for(int userId: event.getUserIds()) {
			if(usersRepo.findById(userId).isPresent()) {
				userSet.add(userId);
			}
		}
		entity.setUserIds(userSet.toArray(new Integer[userSet.size()]));
		ClubEntity club=clubsRepository.findById(event.getEventId()).get();
		if(club!=null) {
		entity.setClub(club);
		return eventsRepository.save(entity);
		}else {
		return null;
		}
		}
		return null;
	}

	@Override
	public String removeEvent(Integer id) {
		eventsRepository.deleteById(id);
		return "Deleted Succesfully";
	}
}
