package com.bedbath.jdalookups.model;

public class Size {

	private String sizeCode;
	private String sizeDescription;
	private String sizeShortDescription;
	private Double totalRows;
	private Double existenceColumn;
	
	public String getSizeCode() {
		return sizeCode;
	}
	public String getSizeDescription() {
		return sizeDescription;
	}
	public String getSizeShortDescription() {
		return sizeShortDescription;
	}
	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}
	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}
	public void setSizeShortDescription(String sizeShortDescription) {
		this.sizeShortDescription = sizeShortDescription;
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
