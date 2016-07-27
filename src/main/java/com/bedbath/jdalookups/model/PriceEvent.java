package com.bedbath.jdalookups.model;

import java.sql.Date;

public class PriceEvent {

	private int eventNumber;
	private String eventDescription;
	private String eventType;
	private int startDate;
	private int endDate;
	private String eventStatus;
	private String eventLevel;
	private String eventReason;
	private String reasonDescription;
	private int pricingMethod;
	private Double dollarOff;
	private int percentOff;
	private String forcedHardMark;
	private String comment1;
	private String comment2;
	private String comment3;
	private String comment4;
	private String comment5;
	private String clearanceSignage;
	
	public String getEventReason() {
		return eventReason;
	}
	public void setEventReason(String eventReason) {
		this.eventReason = eventReason;
	}
	public int getEventNumber() {
		return eventNumber;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public String getEventType() {
		return eventType;
	}
	public int getStartDate() {
		return startDate;
	}
	public int getEndDate() {
		return endDate;
	}
	public String getEventStatus() {
		return eventStatus;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventNumber(int eventNumber) {
		this.eventNumber = eventNumber;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getReasonDescription() {
		return reasonDescription;
	}
	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}
	public int getPricingMethod() {
		return pricingMethod;
	}
	public void setPricingMethod(int pricingMethod) {
		this.pricingMethod = pricingMethod;
	}
	public Double getDollarOff() {
		return dollarOff;
	}
	public void setDollarOff(Double dollarOff) {
		this.dollarOff = dollarOff;
	}
	public int getPercentOff() {
		return percentOff;
	}
	public void setPercentOff(int percentOff) {
		this.percentOff = percentOff;
	}
	public String getForcedHardMark() {
		return forcedHardMark;
	}
	public void setForcedHardMark(String forcedHardMark) {
		this.forcedHardMark = forcedHardMark;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public String getComment2() {
		return comment2;
	}
	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}
	public String getComment3() {
		return comment3;
	}
	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}
	public String getComment4() {
		return comment4;
	}
	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}
	public String getComment5() {
		return comment5;
	}
	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}
	public String getClearanceSignage() {
		return clearanceSignage;
	}
	public void setClearanceSignage(String clearanceSignage) {
		this.clearanceSignage = clearanceSignage;
	}
	
}
