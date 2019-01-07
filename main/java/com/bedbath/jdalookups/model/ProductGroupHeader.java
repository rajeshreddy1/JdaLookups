package com.bedbath.jdalookups.model;

import java.sql.Date;

public class ProductGroupHeader {

	private int groupNumber;
	private String groupDescription;
	private String groupStatus;
	private String groupTypeValue;
	private String groupTypeDescription;
	private Date groupCreateDate;
	private String applicationUser;
	
	public int getGroupNumber() {
		return groupNumber;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public String getGroupStatus() {
		return groupStatus;
	}
	public String getGroupTypeValue() {
		return groupTypeValue;
	}
	public Date getGroupCreateDate() {
		return groupCreateDate;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}
	public void setGroupTypeValue(String groupTypeValue) {
		this.groupTypeValue = groupTypeValue;
	}
	public void setGroupCreateDate(Date groupCreateDate) {
		this.groupCreateDate = groupCreateDate;
	}
	public String getApplicationUser() {
		return applicationUser;
	}
	public void setApplicationUser(String applicationUser) {
		this.applicationUser = applicationUser;
	}
	public String getGroupTypeDescription() {
		return groupTypeDescription;
	}
	public void setGroupTypeDescription(String groupTypeDescription) {
		this.groupTypeDescription = groupTypeDescription;
	}			
}