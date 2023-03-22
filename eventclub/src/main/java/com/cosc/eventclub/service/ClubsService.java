package com.cosc.eventclub.service;

import com.cosc.eventclub.controller.dao.AddClubDao;
import com.cosc.eventclub.entity.ClubEntity;

public interface ClubsService {

	public ClubEntity addClub(AddClubDao club);

	public ClubEntity getClub(Integer id);

	public ClubEntity updateClub(ClubEntity club);

	public String removeClub(Integer id);
}
