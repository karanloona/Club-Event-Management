package com.cosc.eventclub.beans;

import java.util.Date;



public class ClubsBean {
	
	
	private int clubId;
	private String clubname;
	private int[] userIds;
	private int[] evenIds;
	private Date dateAdded;
	
	public ClubsBean(int clubId, String clubname, int[] userIds, int[] evenIds, Date dateAdded) {
		this.clubId = clubId;
		this.clubname = clubname;
		this.userIds = userIds;
		this.evenIds = evenIds;
		this.dateAdded = dateAdded;
	}
	public ClubsBean() {
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public int[] getUserIds() {
		return userIds;
	}
	public void setUserIds(int[] userIds) {
		this.userIds = userIds;
	}
	public int[] getEvenIds() {
		return evenIds;
	}
	public void setEvenIds(int[] evenIds) {
		this.evenIds = evenIds;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	
	
}
