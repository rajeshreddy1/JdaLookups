package com.bedbath.jdalookups.model;

public class PdmAttribute {

	private String AttrCode;
	private String AttrVal;
	private int total;
		
	public String getAttrCode() {
		return AttrCode;
	}
	public void setAttrCode(String attrCode) {
		AttrCode = attrCode;
	}
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
		return "PdmAttribute [AttrCode=" + AttrCode + ", AttrVal=" + AttrVal + ", total=" + total + ", getAttrCode()="
				+ getAttrCode() + ", getAttrVal()=" + getAttrVal() + ", getTotal()=" + getTotal() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
		
}
