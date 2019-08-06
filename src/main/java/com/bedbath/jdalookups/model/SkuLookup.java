package com.bedbath.jdalookups.model;

public class SkuLookup {

	private Long sku;
	private String skuDescription;
	private String status;
	private Double retailPrice;
	private int department;
	private int subDepartment;
	private int classa;
	private int vendor;
	private String vendorPartNumber;
	private String merchandiseGroup;
	private int color;
	private String size;
	private String priceGroup;
	private Double totalRows;
	private Double existenceColumn;
	
	public Long getSku() {
		return sku;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public String getStatus() {
		return status;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public int getDepartment() {
		return department;
	}
	public int getSubDepartment() {
		return subDepartment;
	}
	public int getClassa() {
		return classa;
	}
	public int getVendor() {
		return vendor;
	}
	public String getVendorPartNumber() {
		return vendorPartNumber;
	}
	public String getMerchandiseGroup() {
		return merchandiseGroup;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
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
	public void setVendor(int vendor) {
		this.vendor = vendor;
	}
	public void setVendorPartNumber(String vendorPartNumber) {
		this.vendorPartNumber = vendorPartNumber;
	}
	public void setMerchandiseGroup(String merchandiseGroup) {
		this.merchandiseGroup = merchandiseGroup;
	}
	public int getColor() {
		return color;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPriceGroup() {
		return priceGroup;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
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
