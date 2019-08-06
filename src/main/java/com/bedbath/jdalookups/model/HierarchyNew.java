package com.bedbath.jdalookups.model;

public class HierarchyNew {

	private int department;
	private int subDepartment;
	private int classa;
	private String departmentDescription;
	private String subDepartmentDescription;
	private String classDescription;
	private Double totalRows;
	private Double existenceColumn;
	
	public int getDepartment() {
		return department;
	}
	public int getSubDepartment() {
		return subDepartment;
	}
	public int getClassa() {
		return classa;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public void setSubDepartment(int subDepartment) {
		this.subDepartment = subDepartment;
	}
	public void setClassa(int classa) {
		this.classa = classa;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getSubDepartmentDescription() {
		return subDepartmentDescription;
	}
	public void setSubDepartmentDescription(String subDepartmentDescription) {
		this.subDepartmentDescription = subDepartmentDescription;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
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
