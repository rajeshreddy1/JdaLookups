package com.bedbath.jdalookups.model;

public class MasterEvtGenerator {
	
	private String seqName;
	private String server;
	
	public MasterEvtGenerator() {
		
	}

	public MasterEvtGenerator(String seqName, String server) {
		this.seqName = seqName;
		this.server = server;
	}

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
}
