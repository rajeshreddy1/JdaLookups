package com.bedbath.jdalookups.model;

public class BbsAppValuReq {
	
	private String appKey="";
	private String charVal1="";
	private String charVal2="";
	private String charVal3="";
	private Long numVal1=Long.parseLong("0");
	private Long numVal2=Long.parseLong("0");
	private Long numVal3=Long.parseLong("0");
	private String documentPath="";
	private String note1="";
	private String note2="";
	private String sortFields="";
	private String appendToWhereClause="";
	private String distinctResult="";	
	private int start=0;
	private int limit=100;
			
	public BbsAppValuReq() {
		super();		
	}

	public BbsAppValuReq(String appKey, String charVal1, String charVal2, String charVal3, Long numVal1, Long numVal2, Long numVal3, String documentPath, String note1, String note2, String sortFields, String appendToWhereClause, String distinctResult, int start, int limit) {
		super();
	
		this.appKey = appKey;
		this.charVal1 = charVal1;
		this.charVal2 = charVal2;
		this.charVal3 = charVal3;
		this.numVal1 = numVal1;
		this.numVal2 = numVal2;
		this.numVal3 = numVal3;
		this.documentPath = documentPath;
		this.note1 = note1;
		this.note2 = note2;
		this.sortFields = sortFields;
		this.appendToWhereClause = appendToWhereClause;
		this.distinctResult = distinctResult;
		this.start = start;
		this.limit = limit;
				
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getCharVal1() {
		return charVal1;
	}

	public void setCharVal1(String charVal1) {
		this.charVal1 = charVal1;
	}

	public String getCharVal2() {
		return charVal2;
	}

	public void setCharVal2(String charVal2) {
		this.charVal2 = charVal2;
	}

	public String getCharVal3() {
		return charVal3;
	}

	public void setCharVal3(String charVal3) {
		this.charVal3 = charVal3;
	}

	public Long getNumVal1() {
		return numVal1;
	}

	public void setNumVal1(Long numVal1) {
		this.numVal1 = numVal1;
	}

	public Long getNumVal2() {
		return numVal2;
	}

	public void setNumVal2(Long numVal2) {
		this.numVal2 = numVal2;
	}

	public Long getNumVal3() {
		return numVal3;
	}

	public void setNumVal3(Long numVal3) {
		this.numVal3 = numVal3;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getSortFields() {
		return sortFields;
	}

	public void setSortFields(String sortFields) {
		this.sortFields = sortFields;
	}

	public String getAppendToWhereClause() {
		return appendToWhereClause;
	}

	public void setAppendToWhereClause(String appendToWhereClause) {
		this.appendToWhereClause = appendToWhereClause;
	}

	public String getDistinctResult() {
		return distinctResult;
	}

	public void setDistinctResult(String distinctResult) {
		this.distinctResult = distinctResult;
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
		
}
