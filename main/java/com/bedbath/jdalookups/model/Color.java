package com.bedbath.jdalookups.model;

public class Color {

	private int colorCode;
	private String colorDescription;
	private String shortDescription;
	private Double totalRows;
	private Double existenceColumn;
		
	public int getColorCode() {
		return colorCode;
	}
	public String getColorDescription() {
		return colorDescription;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}
	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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
