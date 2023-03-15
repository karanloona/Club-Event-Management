package com.cosc.eventclub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="financial_transaction")
public class TransactionEntity {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="date_added")
	private Date dateAdded;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="amount")
	private float amount;
	
	@Column(name="event_id")
	private int eventId;

	public TransactionEntity() {
	}

	public TransactionEntity(int transactionId, Date dateAdded, int userId, float amount, int eventId) {
		this.transactionId = transactionId;
		this.dateAdded = dateAdded;
		this.userId = userId;
		this.amount = amount;
		this.eventId = eventId;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
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
