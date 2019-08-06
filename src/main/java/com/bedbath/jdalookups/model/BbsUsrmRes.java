package com.bedbath.jdalookups.model;

public class BbsUsrmRes {
	
	private String user;
	private String firstName;
	private String lastName;
	private String fullName;
	private int securityLevel;
	private int totalRows;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	@Override
	public String toString() {
		return "BbsUsrmRes [userId=" + user + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", securityLevel=" + securityLevel + ", totalRows=" + totalRows + "]";
	}

}
