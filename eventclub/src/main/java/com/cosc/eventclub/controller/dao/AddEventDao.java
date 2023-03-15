package com.cosc.eventclub.controller.dao;

public class AddEventDao {
	
	private String eventName;
	private float eventPrice;
	private int clubId;
	
	public AddEventDao() {
	}
	public AddEventDao(String eventName, float eventPrice, int clubId) {
		this.eventName = eventName;
		this.eventPrice = eventPrice;
		this.clubId = clubId;
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
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

}
