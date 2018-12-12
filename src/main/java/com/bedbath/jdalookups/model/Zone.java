package com.bedbath.jdalookups.model;

public class Zone {

	private int zoneNumber;
	private String zoneDescription;
	private String shortDescription;
	private String countryCode;
	private Double conversionRate;
	private String currencyCode;
	private boolean hasPacDtl;
	private Double totalRows;
	
	public int getZoneNumber() {
		return zoneNumber;
	}
	public String getZoneDescription() {
		return zoneDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setZoneNumber(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}
	public void setZoneDescription(String zoneDescription) {
		this.zoneDescription = zoneDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Double getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
	public boolean hasPacDtl() {
		return hasPacDtl;
	}
	public void setHasPacDtl(boolean hasPacDtl) {
		this.hasPacDtl = hasPacDtl;
	}	
	
}
