package com.cosc.eventclub.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class EventsEntity {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_price")
	private float eventPrice;
	
	@Column(name="date_added")
	private Date dateAdded;
	
	@Column(name="user_ids")
	private Integer[] userIds;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "club_id", referencedColumnName = "club_id")
	 private ClubEntity club;

	 public EventsEntity() {
		}

		public EventsEntity(int eventId, String eventName, float eventPrice, Date dateAdded, Integer[] userIds,
				ClubEntity club) {
			this.eventId = eventId;
			this.eventName = eventName;
			this.eventPrice = eventPrice;
			this.dateAdded = dateAdded;
			this.userIds = userIds;
			this.club = club;
		}
		
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public float getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(float eventPrice) {
		this.eventPrice = eventPrice;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Integer[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Integer[] userIds) {
		this.userIds = userIds;
	}

	public ClubEntity getClub() {
		return club;
	}

	public void setClub(ClubEntity club) {
		this.club = club;
	}
	
}
