package com.cosc.eventclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosc.eventclub.entity.ClubEntity;

@Repository
public interface ClubsRepository extends JpaRepository<ClubEntity, Integer> {

    ClubEntity findByClubname(String clubname);
}
