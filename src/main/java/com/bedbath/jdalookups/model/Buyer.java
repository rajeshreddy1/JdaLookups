package com.bedbath.jdalookups.model;

public class Buyer {

	private String buyerNumber;
	private String buyerName;
	private Long startDate;
	private Double totalRows;
	
	public String getBuyerNumber() {
		return buyerNumber;
	}
	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Long getStartDate() {
		return startDate;
	}
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
		
}
