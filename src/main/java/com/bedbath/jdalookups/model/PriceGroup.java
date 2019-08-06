package com.bedbath.jdalookups.model;

public class PriceGroup {

	private String priceGroupCode;
	private String priceGroupDescription;
	private Double totalRows;
	private Double existenceColumn;
		
	public String getPriceGroupCode() {		
		return priceGroupCode;
	}
	public String getPriceGroupDescription() {
		return priceGroupDescription;
	}
	public void setPriceGroupCode(String priceGroupCode) {
		this.priceGroupCode = priceGroupCode;
	}
	public void setPriceGroupDescription(String priceGroupDescription) {
		this.priceGroupDescription = priceGroupDescription;
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
