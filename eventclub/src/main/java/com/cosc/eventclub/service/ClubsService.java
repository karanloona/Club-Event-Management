package com.cosc.eventclub.service;

import com.cosc.eventclub.entity.ClubEntity;

public interface ClubsService {

	public ClubEntity addClub(ClubEntity club);

	public ClubEntity getClub(Integer id);

	public ClubEntity updateClub(ClubEntity club);

	public String removeClub(Integer id);
}
