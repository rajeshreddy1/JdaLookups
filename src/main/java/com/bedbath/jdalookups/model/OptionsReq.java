package com.bedbath.jdalookups.model;

import java.util.ArrayList;

public class OptionsReq {
	
	private String action="";
	private String sort_Field="";
	private int start=0;
	private int limit=100;
	private ArrayList<Integer> search_option = new ArrayList<Integer>();
	private String server;
		
	public OptionsReq() {
		super();		
	}

	public OptionsReq(String action, String sort_Field, int start, int limit, ArrayList<Integer> search_option, String server) {
		super();
		this.action = action;
		this.sort_Field = sort_Field;
		this.start = start;
		this.limit = limit;
		this.search_option = search_option;
		this.server = server;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSort_Field() {
		return sort_Field;
	}
	public void setSort_Field(String sort_Field) {
		this.sort_Field = sort_Field;
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
	public ArrayList<Integer> getSearch_option() {
		return search_option;
	}
	public void setSearch_option(ArrayList<Integer> search_option) {
		this.search_option = search_option;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	
}
