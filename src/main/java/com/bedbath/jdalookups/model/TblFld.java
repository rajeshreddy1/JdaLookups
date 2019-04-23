package com.bedbath.jdalookups.model;

public class TblFld {

	private String fieldName;
	private String fieldValue;
	private String description;
	private String defaultFlag;
	private Double totalRows;
	
	public String getFieldName() {
		return fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public String getDescription() {
		return description;
	}
	public String getDefaultFlag() {
		return defaultFlag;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}
}
