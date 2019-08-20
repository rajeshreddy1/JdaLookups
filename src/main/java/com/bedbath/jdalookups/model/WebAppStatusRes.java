package com.bedbath.jdalookups.model;

public class WebAppStatusRes {
	
	private String effectiveFrom;
	private String effectiveTo;
	private String propertyValue;
	
	public String getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	public String getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(String effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	@Override
	public String toString() {
		return "WebAppStatusRes [effectiveFrom=" + effectiveFrom + ", effectiveTo=" + effectiveTo + ", propertyValue="
				+ propertyValue + "]";
	}
}
