package com.cosc.eventclub.controller.dao;

public class AddClubDao {
    private String clubname;
    private int[] userIds;
    public AddClubDao() {
    }
    public String getClubname() {
        return clubname;
    }
    public AddClubDao(String clubname, int[] userIds) {
        this.clubname = clubname;
        this.userIds = userIds;
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
    
}
