package com.bedbath.jdalookups.dao;

import java.util.List;
import java.util.Map;

import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.OptionsReq;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.SkuOrUpcSearchReq;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;

public interface JdaLookupDAO {
	
	public List<SkuLookup> getLookupSkus(String sql, String server) throws Exception;		
	public List<Hierarchy> getHierarchy(String sql, String server) throws Exception;
	public List<ProductGroupHeader> getLookupProductGroups(String sql, String server) throws Exception;
	public List<Vendor> getVendors(String sql, String server) throws Exception;
	public List<Color> getColors(String sql, String server) throws Exception;
	public List<Size> getSizes(String sql, String server) throws Exception;
	public List<MerchandiseGroup> getMerchandiseGroups(String sql, String server) throws Exception;
	public List<PriceGroup> getPriceGroups(String sql, String server) throws Exception;	
	public List<Store> getStores(String sql, String server) throws Exception;
	public List<Zone> getZones(String sql, String server) throws Exception;
	public List<StateProvince> getStates(String sql, String server) throws Exception;
	public String getLookupName(String sql, String server) throws Exception;

	public Map getVendors(int vendorNumber, String vendorName, String vendorType, String scacCode, String sortFields, String existenceColumn,  String appendToWhrClause, int start, int limit, String server) throws Exception;
	public Map getLookupSkus(int departmentNumber, int subDepartmentNumber, int classNumber, int vendorNumber, String vendorPartNumber, Long skuNumber, Long upcNumber, String skuDescription, String statuses, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getHierarchy(String action, int departmentNumber, int subDepartmentNumber, int classNumber, String hierarchyName, String sortFields, String existenceColumn, String appendToWhrClause, int start, int limit, String server) throws Exception;	
	public Map getTitles(String action, String server) throws Exception;
	public Map getManagers(String action, String title, String server) throws Exception;
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception;
	public Map gettblfldInnersltentries(String action, String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception;
	public Map getTblFldReasons(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception;
	public Map getNextMstEvntNum(String sql_statement, String server) throws Exception;
	public Map getConcepts(String existenceColumn, String appendToWhrClause, String server) throws Exception;
	public Map getInvCal(String inputDate, String server) throws Exception;
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception;
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;	
	public Map getZones(int zoneNumber, String zoneName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getRegions(int regionNumber, String regionName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getDistricts(int districtNumber, int regionNumber, String districtName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;	
	public Map getBuyers(String buyerNumber, String buyerName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getPriceEvents(String eventType, /*int*/ String eventNumber, String eventDescription, int startDate, String eventStatus, String sortFields, int start, int limit, String server) throws Exception;
	public Map getCodes(String codeType, String code, String codeDescription, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getCircularHeaders(String action, Long circularId, String circularName, String circularType, String inHomeDate, String sortFields, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getStoreBracketHeaders(int bracketNumber, String bracketDescription, String bracketSource, String bracketType, String sortFields, int start, int limit, String server) throws Exception;
	public Map getMasterEventHeaders(String masterEventNumber, String eventDescription, String startDate, String eventTypes, String applicationId, String sortFields, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, Long numValue2, Long numValue3, String documentPath, String note1, String note2, String sequenceNumber, String user, String server) throws Exception;
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, String numValue2String, int numValue2Length, Long numValue3, String documentPath, String note1, String note2, String sequenceNumber, String user, String server) throws Exception;
	public Map getCampaigns(int campaignId, String campaignName, String sortField, int start, int limit, String server) throws Exception;
	public Map getBbsUsrmUsers(String action, String sqlStatement, String server) throws Exception;	
	Map<String, ? extends Object> searchPdmAttribute(String type, String description, String server, int start, int limit, boolean feature) throws Exception;;
	Map<String, ? extends Object> searchSkuOrUpc(SkuOrUpcSearchReq req) throws Exception;
	
	Map<String, ? extends Object> getOptionsRecord(OptionsReq req) throws Exception;
	
	
}
