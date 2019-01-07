package com.bedbath.jdalookups.model;

public class Hierarchy {

	private int department;
	private int subDepartment;
	private int classa;
	private String hierarchyDescription;
	
	public int getDepartment() {
		return department;
	}
	public int getSubDepartment() {
		return subDepartment;
	}
	public int getClassa() {
		return classa;
	}
	public String getHierarchyDescription() {
		return hierarchyDescription;
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
	public void setHierarchyDescription(String hierarchyDescription) {
		this.hierarchyDescription = hierarchyDescription;
	}
		
}
