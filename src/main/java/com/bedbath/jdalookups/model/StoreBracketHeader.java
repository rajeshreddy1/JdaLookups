package com.bedbath.jdalookups.model;

public class StoreBracketHeader {

	private int bracketNumber;
	private String bracketDescription;
	private int departmentNumber;
	private int subDepartmentNumber;
	private int classNumber;
	private String source;
	private String bracketType;
	private Double totalRows;
	
	public int getBracketNumber() {
		return bracketNumber;
	}
	public void setBracketNumber(int bracketNumber) {
		this.bracketNumber = bracketNumber;
	}
	public String getBracketDescription() {
		return bracketDescription;
	}
	public void setBracketDescription(String bracketDescription) {
		this.bracketDescription = bracketDescription;
	}
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public int getSubDepartmentNumber() {
		return subDepartmentNumber;
	}
	public void setSubDepartmentNumber(int subDepartmentNumber) {
		this.subDepartmentNumber = subDepartmentNumber;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBracketType() {
		return bracketType;
	}
	public void setBracketType(String bracketType) {
		this.bracketType = bracketType;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}		
}
