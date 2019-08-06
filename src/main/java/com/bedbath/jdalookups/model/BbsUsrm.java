package com.bedbath.jdalookups.model;

public class BbsUsrm {
	
	private String appId;
	private int store;
	private String sortFields;
	private String appendToWhrClause;
	private int start;
	private int limit;
	private String server;
	
	public BbsUsrm() {
		
	}

	public BbsUsrm(String appId, int store, String sortFields, String appendToWhrClause, int start, int limit,
			String server) {
		this.appId = appId;
		this.store = store;
		this.sortFields = sortFields;
		this.appendToWhrClause = appendToWhrClause;
		this.start = start;
		this.limit = limit;
		this.server = server;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public String getSortFields() {
		return sortFields;
	}

	public void setSortFields(String sortFields) {
		this.sortFields = sortFields;
	}

	public String getAppendToWhrClause() {
		return appendToWhrClause;
	}

	public void setAppendToWhrClause(String appendToWhrClause) {
		this.appendToWhrClause = appendToWhrClause;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
}
