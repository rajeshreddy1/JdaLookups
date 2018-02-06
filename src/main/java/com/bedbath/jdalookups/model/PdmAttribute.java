package com.bedbath.jdalookups.model;

public class PdmAttribute {

	private String AttrVal;
	private int total;
	
	public String getAttrVal() {
		return AttrVal;
	}
	public void setAttrVal(String attrVal) {
		AttrVal = attrVal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "PdmAttribute [AttrVal=" + AttrVal + ", total=" + total + "]";
	}
		
}
