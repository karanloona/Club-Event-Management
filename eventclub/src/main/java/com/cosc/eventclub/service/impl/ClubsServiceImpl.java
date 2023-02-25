package com.cosc.eventclub.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cosc.eventclub.entity.ClubEntity;
import com.cosc.eventclub.repository.ClubsRepository;
import com.cosc.eventclub.repository.UsersRepository;
import com.cosc.eventclub.service.ClubsService;

@Service
public class ClubsServiceImpl implements ClubsService {

	private final ClubsRepository clubsRepository;
	
	private final UsersRepository usersRepository;
	
	public ClubsServiceImpl(ClubsRepository clubsRepository,UsersRepository usersRepository) {
		this.clubsRepository=clubsRepository;
		this.usersRepository=usersRepository;
	}
	
	@Override
	public ClubEntity addClub(ClubEntity club) {
		if(clubsRepository.findById(club.getClubId()).isPresent()) {
			return null;
		}
		for(Integer id:club.getUserIds()) {
			if(!usersRepository.findById(id).isPresent()) {
				return null;
			}
		}
		
		return clubsRepository.save(new ClubEntity(club.getClubId(), club.getClubname(), club.getUserIds(),club.getEvenIds() , new Date()));
	}

	@Override
	public ClubEntity getClub(Integer id) {
		ClubEntity club=clubsRepository.findById(id).get();
		if(club==null)
		{
		return null;
		}
		return club;
	}

	@Override
	public ClubEntity updateClub(ClubEntity club) {
		ClubEntity clubEntity=clubsRepository.findById(club.getClubId()).get();
		if(clubEntity.equals(null)) {
			return null;
		}
		for(Integer id:club.getUserIds()) {
			if(!usersRepository.findById(id).isPresent()) {
				return null;
			}
		}
		club.setDateAdded(new Date());
		return clubsRepository.save(club);
	}

	@Override
	public String removeClub(Integer id) {
		clubsRepository.deleteById(id);
		return "Succesfully Deleted";
	}
	
	
	
	
}
