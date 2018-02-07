package com.bedbath.jdalookups.model;

public class SkuOrUpcSearchRes {

	private Long sku;
	private Long upc;
	private String skuDescription;
	private int dept;
	private String deptDesc;
	private int subDept;
	private String subDeptDesc;
	private int classa;
	private String classaDesc;
	private String status;
	private Double retailPrice;
	private String buyer;
	private String priceGroup;
	private Long total;
	
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public Long getUpc() {
		return upc;
	}
	public void setUpc(Long upc) {
		this.upc = upc;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public int getSubDept() {
		return subDept;
	}
	public void setSubDept(int subDept) {
		this.subDept = subDept;
	}
	public String getSubDeptDesc() {
		return subDeptDesc;
	}
	public void setSubDeptDesc(String subDeptDesc) {
		this.subDeptDesc = subDeptDesc;
	}
	public int getClassa() {
		return classa;
	}
	public void setClassa(int classa) {
		this.classa = classa;
	}
	public String getClassaDesc() {
		return classaDesc;
	}
	public void setClassaDesc(String classaDesc) {
		this.classaDesc = classaDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getPriceGroup() {
		return priceGroup;
	}
	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "SkuOrUpcSearchRes [sku=" + sku + ", upc=" + upc + ", skuDescription=" + skuDescription + ", dept="
				+ dept + ", deptDesc=" + deptDesc + ", subDept=" + subDept + ", subDeptDesc=" + subDeptDesc
				+ ", classa=" + classa + ", classaDesc=" + classaDesc + ", status=" + status + ", retailPrice="
				+ retailPrice + ", buyer=" + buyer + ", priceGroup=" + priceGroup + ", total=" + total + "]";
	}
			
}
