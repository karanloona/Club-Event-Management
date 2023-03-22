package com.cosc.eventclub.controller.dao;

public class AddTransactionDao {
	
	
	private int userId;
	private float amount;
	private int eventId;
	
	public AddTransactionDao() {
	}
	public AddTransactionDao(int userId, float amount, int eventId) {
		this.userId = userId;
		this.amount = amount;
		this.eventId = eventId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
