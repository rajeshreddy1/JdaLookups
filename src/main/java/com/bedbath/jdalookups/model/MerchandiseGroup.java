package com.bedbath.jdalookups.model;

public class MerchandiseGroup {

	private String merchandiseGroupCode;
	private String merchandiseGroupDescription;
	private Double totalRows;
	private Double existenceColumn;
	
	public String getMerchandiseGroupCode() {
		return merchandiseGroupCode;
	}
	public String getMerchandiseGroupDescription() {
		return merchandiseGroupDescription;
	}
	public void setMerchandiseGroupCode(String merchandiseGroupCode) {
		this.merchandiseGroupCode = merchandiseGroupCode;
	}
	public void setMerchandiseGroupDescription(String merchandiseGroupDescription) {
		this.merchandiseGroupDescription = merchandiseGroupDescription;
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
