package com.bedbath.jdalookups.model;

public class Vendor {

	private int vendorNumber;
	private String vendorName;
	private String vendorType;
	private String buyerNumber;
	
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
			
}
