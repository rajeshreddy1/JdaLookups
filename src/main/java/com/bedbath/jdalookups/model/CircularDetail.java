package com.bedbath.jdalookups.model;

public class CircularDetail {

	private int circularId;
	private String circularType;
	private String inHomeDate;
	private String circularName;
	private Long sku;
	private String skuDescription;	
	private Double totalRows;
	
	public int getCircularId() {
		return circularId;
	}
	public void setCircularId(int circularId) {
		this.circularId = circularId;
	}
	public String getCircularType() {
		return circularType;
	}
	public void setCircularType(String circularType) {
		this.circularType = circularType;
	}
	public String getInHomeDate() {
		return inHomeDate;
	}
	public void setInHomeDate(String inHomeDate) {
		this.inHomeDate = inHomeDate;
	}
	public String getCircularName() {
		return circularName;
	}
	public void setCircularName(String circularName) {
		this.circularName = circularName;
	}	
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
		
}
