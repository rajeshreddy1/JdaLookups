package com.bedbath.jdalookups.model;

public class WebAppStatusReq {

	private String appId;
	private String concept;
	private String country;
	private String server;
	
	public WebAppStatusReq(){
		
	}
	
	public WebAppStatusReq(String appId, String concept, String country, String server) {
		this.appId = appId;
		this.concept = concept;
		this.country = country;
		this.server = server;
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
}
