package com.bedbath.jdalookups.model;

public class Region {

	private int regionNumber;
	private String regionName;
	private String regionManager;
	private Long phoneNumber;
	private String shortName;
	private Double totalRows;
	
	public int getRegionNumber() {
		return regionNumber;
	}
	public void setRegionNumber(int regionNumber) {
		this.regionNumber = regionNumber;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getRegionManager() {
		return regionManager;
	}
	public void setRegionManager(String regionManager) {
		this.regionManager = regionManager;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
			
}
