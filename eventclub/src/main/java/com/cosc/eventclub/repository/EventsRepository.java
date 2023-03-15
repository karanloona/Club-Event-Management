package com.cosc.eventclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosc.eventclub.entity.EventsEntity;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Integer> {

}
