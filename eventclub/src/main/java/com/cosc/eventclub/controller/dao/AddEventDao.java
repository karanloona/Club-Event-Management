package com.cosc.eventclub.controller.dao;

public class AddEventDao {
	
	private String eventName;
	private float eventPrice;
	private int clubId;
	private Integer[] userIds;
	
	public AddEventDao() {
	}
	public AddEventDao(String eventName, float eventPrice, int clubId, Integer[] userIds) {
		this.eventName = eventName;
		this.eventPrice = eventPrice;
		this.clubId = clubId;
		this.userIds=userIds;
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
	public Integer[] getUserIds() {
		return userIds;
	}
	public void setUserIds(Integer[] userIds) {
		this.userIds = userIds;
	}

}
