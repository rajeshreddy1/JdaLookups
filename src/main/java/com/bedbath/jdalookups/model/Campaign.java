package com.bedbath.jdalookups.model;

public class Campaign {
	
	private int campaignId;
	private String campaignName;
	private Double totalRows;
	
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public Double getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Double totalRows) {
		this.totalRows = totalRows;
	}	
	
}
