package com.project.model;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.math.BigInteger;
import java.util.Date;

public class UserHistory {
	private Integer userId;
	private Integer createdBy;
	private String activity;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}


}
