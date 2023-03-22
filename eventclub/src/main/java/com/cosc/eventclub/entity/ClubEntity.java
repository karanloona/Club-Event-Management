package com.cosc.eventclub.entity;

import java.util.Date;

import javax.persistence.*;

import com.cosc.eventclub.beans.ClubsBean;


@Entity
@Table(name="clubs")
public class ClubEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="club_id")
	private int clubId;
	@Column(name="clubname")
	private String clubname;
	@Column(name="user_ids")
	private int[] userIds;
	@Column(name="event_ids")
	private int[] evenIds;
	@Column(name="date_added")
	private Date dateAdded;
	
	public ClubEntity() {
	}
	public ClubEntity(int clubId, String clubname, int[] userIds, int[] evenIds, Date dateAdded) {
		this.clubId = clubId;
		this.clubname = clubname;
		this.userIds = userIds;
		this.evenIds = evenIds;
		this.dateAdded = dateAdded;
	}
	
	public ClubEntity(String clubname, int[] userIds, int[] evenIds, Date date) {
		this.clubname=clubname;
		this.userIds=userIds;
		this.evenIds=evenIds;
		this.dateAdded=date;

	}
	public ClubsBean getBeanfromEntity(ClubEntity club) {
		return new ClubsBean(club.getClubId(), club.getClubname(), club.getUserIds(), club.getEvenIds(), club.getDateAdded()); 
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
