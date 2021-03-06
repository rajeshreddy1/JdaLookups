package com.bedbath.jdalookups.model;

public class SkuOrUpcSearchReq {

	private int searchListNo;
	private String type;
	private int department;
	private int subDepartment;
	private int classa;
	private int colorCode;
	private String sizeCode;
	private String webProduct;
	private String webCollection;
	private String season;
	private String theme;
	private String region;
	private String lifeStyle;
	private String itemStatus;
	private long skuNumber;
	private long upcNumber;
	private String itemDescription;
	private int vendor;
	private String partNumber;
	private String vdc;
	private String vendorCollection;
	private String vendorStyle;
	private String ecomBrand;
	private String productType;
	private int listNumber;
	private String merchandiseGroup;
	private int priceFamily;
	private float retailFrom;
	private float retailTo;
	private float mapFrom;
	private float mapTo;
	private float msrpFrom;
	private float msrpTo;
	private String buyer;
	private String exclusivity;
	private String chefCentral;
	private String profile;
	private String eph;
	private String masterEvent;
	private String jdaEvent;
	private int mixMatchCategory;
	private int casePack;
	private int lastReceiptStart;
	private int lastReceiptEnd;
	private int agedDaysMin;
	private int agedDaysMax;
	private String adCode;
	private String dealCode;
	private String ctsSeason;
	private int start;
	private int limit;
	private String server;
	private int zone;
	private String sortBy = "a.inumbr|SKU";
	private String whereClause = "";
	private int seqNum;
	
	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public int getCasePack() {
		return casePack;
	}

	public void setCasePack(int casePack) {
		this.casePack = casePack;
	}

	public int getLastReceiptStart() {
		return lastReceiptStart;
	}

	public void setLastReceiptStart(int lastReceiptStart) {
		this.lastReceiptStart = lastReceiptStart;
	}

	public int getLastReceiptEnd() {
		return lastReceiptEnd;
	}

	public void setLastReceiptEnd(int lastReceiptEnd) {
		this.lastReceiptEnd = lastReceiptEnd;
	}

	public int getAgedDaysMin() {
		return agedDaysMin;
	}

	public void setAgedDaysMin(int agedDaysMin) {
		this.agedDaysMin = agedDaysMin;
	}

	public int getAgedDaysMax() {
		return agedDaysMax;
	}

	public void setAgedDaysMax(int agedDaysMax) {
		this.agedDaysMax = agedDaysMax;
	}

	public String getDealCode() {
		return dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	public String getCtsSeason() {
		return ctsSeason;
	}

	public void setCtsSeason(String ctsSeason) {
		this.ctsSeason = ctsSeason;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public String getMasterEvent() {
		return masterEvent;
	}

	public void setMasterEvent(String masterEvent) {
		this.masterEvent = masterEvent;
	}

	public String getJdaEvent() {
		return jdaEvent;
	}

	public void setJdaEvent(String jdaEvent) {
		this.jdaEvent = jdaEvent;
	}

	public int getMixMatchCategory() {
		return mixMatchCategory;
	}

	public void setMixMatchCategory(int mixMatchCategory) {
		this.mixMatchCategory = mixMatchCategory;
	}

	public int getSearchListNo() {
		return searchListNo;
	}

	public void setSearchListNo(int searchListNo) {
		this.searchListNo = searchListNo;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getDepartment() {
		return department;
	}



	public void setDepartment(int department) {
		this.department = department;
	}



	public int getSubDepartment() {
		return subDepartment;
	}



	public void setSubDepartment(int subDepartment) {
		this.subDepartment = subDepartment;
	}



	public int getClassa() {
		return classa;
	}



	public void setClassa(int classa) {
		this.classa = classa;
	}



	public int getColorCode() {
		return colorCode;
	}



	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}



	public String getSizeCode() {
		return sizeCode;
	}



	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}



	public String getWebProduct() {
		return webProduct;
	}



	public void setWebProduct(String webProduct) {
		this.webProduct = webProduct;
	}



	public String getWebCollection() {
		return webCollection;
	}



	public void setWebCollection(String webCollection) {
		this.webCollection = webCollection;
	}



	public String getSeason() {
		return season;
	}



	public void setSeason(String season) {
		this.season = season;
	}



	public String getTheme() {
		return theme;
	}



	public void setTheme(String theme) {
		this.theme = theme;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getLifeStyle() {
		return lifeStyle;
	}



	public void setLifeStyle(String lifeStyle) {
		this.lifeStyle = lifeStyle;
	}



	public String getItemStatus() {
		return itemStatus;
	}



	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}



	public long getSkuNumber() {
		return skuNumber;
	}



	public void setSkuNumber(long skuNumber) {
		this.skuNumber = skuNumber;
	}



	public long getUpcNumber() {
		return upcNumber;
	}



	public void setUpcNumber(long upcNumber) {
		this.upcNumber = upcNumber;
	}



	public String getItemDescription() {
		return itemDescription;
	}



	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}



	public int getVendor() {
		return vendor;
	}



	public void setVendor(int vendor) {
		this.vendor = vendor;
	}



	public String getPartNumber() {
		return partNumber;
	}



	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}



	public String getVdc() {
		return vdc;
	}



	public void setVdc(String vdc) {
		this.vdc = vdc;
	}



	public String getVendorCollection() {
		return vendorCollection;
	}



	public void setVendorCollection(String vendorCollection) {
		this.vendorCollection = vendorCollection;
	}



	public String getVendorStyle() {
		return vendorStyle;
	}



	public void setVendorStyle(String vendorStyle) {
		this.vendorStyle = vendorStyle;
	}



	public String getEcomBrand() {
		return ecomBrand;
	}



	public void setEcomBrand(String ecomBrand) {
		this.ecomBrand = ecomBrand;
	}



	public String getProductType() {
		return productType;
	}



	public void setProductType(String productType) {
		this.productType = productType;
	}



	public int getListNumber() {
		return listNumber;
	}



	public void setListNumber(int listNumber) {
		this.listNumber = listNumber;
	}



	public String getMerchandiseGroup() {
		return merchandiseGroup;
	}



	public void setMerchandiseGroup(String merchandiseGroup) {
		this.merchandiseGroup = merchandiseGroup;
	}



	public int getPriceFamily() {
		return priceFamily;
	}



	public void setPriceFamily(int priceFamily) {
		this.priceFamily = priceFamily;
	}



	public float getRetailFrom() {
		return retailFrom;
	}



	public void setRetailFrom(float retailFrom) {
		this.retailFrom = retailFrom;
	}



	public float getRetailTo() {
		return retailTo;
	}



	public void setRetailTo(float retailTo) {
		this.retailTo = retailTo;
	}



	public float getMapFrom() {
		return mapFrom;
	}



	public void setMapFrom(float mapFrom) {
		this.mapFrom = mapFrom;
	}



	public float getMapTo() {
		return mapTo;
	}



	public void setMapTo(float mapTo) {
		this.mapTo = mapTo;
	}



	public float getMsrpFrom() {
		return msrpFrom;
	}



	public void setMsrpFrom(float msrpFrom) {
		this.msrpFrom = msrpFrom;
	}



	public float getMsrpTo() {
		return msrpTo;
	}



	public void setMsrpTo(float msrpTo) {
		this.msrpTo = msrpTo;
	}



	public String getBuyer() {
		return buyer;
	}



	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}



	public String getExclusivity() {
		return exclusivity;
	}



	public void setExclusivity(String exclusivity) {
		this.exclusivity = exclusivity;
	}



	public String getChefCentral() {
		return chefCentral;
	}



	public void setChefCentral(String chefCentral) {
		this.chefCentral = chefCentral;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public String getEph() {
		return eph;
	}



	public void setEph(String eph) {
		this.eph = eph;
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

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}
	
	
	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	

	public String getWhereClause() {
		return whereClause;
	}

	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}

	@Override
	public String toString() {
		return "SkuOrUpcSearchReq [searchListNo=" + searchListNo + ", type=" + type + ", department=" + department
				+ ", subDepartment=" + subDepartment + ", classa=" + classa + ", colorCode=" + colorCode + ", sizeCode="
				+ sizeCode + ", webProduct=" + webProduct + ", webCollection=" + webCollection + ", season=" + season
				+ ", theme=" + theme + ", region=" + region + ", lifeStyle=" + lifeStyle + ", itemStatus=" + itemStatus
				+ ", skuNumber=" + skuNumber + ", upcNumber=" + upcNumber + ", itemDescription=" + itemDescription
				+ ", vendor=" + vendor + ", partNumber=" + partNumber + ", vdc=" + vdc + ", vendorCollection="
				+ vendorCollection + ", vendorStyle=" + vendorStyle + ", ecomBrand=" + ecomBrand + ", productType="
				+ productType + ", listNumber=" + listNumber + ", merchandiseGroup=" + merchandiseGroup
				+ ", priceFamily=" + priceFamily + ", retailFrom=" + retailFrom + ", retailTo=" + retailTo + ", mapFrom="
				+ mapFrom + ", mapTo=" + mapTo + ", msrpFrom=" + msrpFrom + ", msrpTo=" + msrpTo + ", buyer=" + buyer
				+ ", exclusivity=" + exclusivity + ", chefCentral=" + chefCentral + ", profile=" + profile + ", eph="
				+ eph + ", masterEvent=" + masterEvent + ", jdaEvent=" + jdaEvent + ", mixMatchCategory="
				+ mixMatchCategory + ", casePack=" + casePack + ", lastReceiptStart=" + lastReceiptStart
				+ ", lastReceiptEnd=" + lastReceiptEnd + ", agedDaysMin=" + agedDaysMin + ", agedDaysMax=" + agedDaysMax
				+ ", adCode=" + adCode + ", dealCode=" + dealCode + ", ctsSeason=" + ctsSeason + ", start=" + start
				+ ", limit=" + limit + ", server=" + server + ", zone=" + zone + ", sortBy=" + sortBy + ", whereClause="
				+ whereClause + ", seqNum=" + seqNum + "]";
	}
		
}
