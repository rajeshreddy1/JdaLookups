package com.bedbath.jdalookups.model;

public class Vendor {

	private int vendorNumber;
	private String vendorName;
	private String vendorType;
	private String buyerNumber;
	private String importFlag;
	private String scacCode;
	private Double totalRows;
	private Double existenceColumn;
	
	public int getVendorNumber() {
		return vendorNumber;
	}
	public String getVendorName() {
		return vendorName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorNumber(int vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getBuyerNumber() {
		return buyerNumber;
	}
	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}
	public String getImportFlag() {
		return importFlag;
	}
	public void setImportFlag(String importFlag) {
		this.importFlag = importFlag;
	}
	public String getScacCode() {
		return scacCode;
	}
	public void setScacCode(String scacCode) {
		this.scacCode = scacCode;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
	public Double getExistenceColumn() {
		return existenceColumn;
	}
	public void setExistenceColumn(Double existenceColumn) {
		this.existenceColumn = existenceColumn;
	}
			
}
