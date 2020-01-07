package com.bedbath.jdalookups.model;

public class SkuCount {
	
	private String masterEvent;
	private int sequenceNumber;
	private String appId;
	private String jdaEvent;
	private String server;
	
	public SkuCount() {
		
	}

	public SkuCount(String masterEvent, int sequenceNumber, String appId, String jdaEvent, String server) {
		this.masterEvent = masterEvent;
		this.sequenceNumber = sequenceNumber;
		this.appId = appId;
		this.jdaEvent = jdaEvent;
		this.server = server;
	}

	public String getMasterEvent() {
		return masterEvent;
	}

	public void setMasterEvent(String masterEvent) {
		this.masterEvent = masterEvent;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getJdaEvent() {
		return jdaEvent;
	}

	public void setJdaEvent(String jdaEvent) {
		this.jdaEvent = jdaEvent;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
