package com.bedbath.jdalookups.service;

import java.util.List;
import java.util.Map;

import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.TblFld;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;

public interface JdaLookupService {

	public List<SkuLookup> getLookupSkus(Long groupNumber, int department, int subDepartment , int classa, int vendor , String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String itemStatus, String server, int start, int limit) throws Exception;
	public List<ProductGroupHeader> getLookupProductGroups(Long groupNumber, String description, String server, int start, int limit) throws Exception;	
	public List<Hierarchy> getHierarchy(String level, int department, int subDepartment, int classa, String description, String server, int start, int limit) throws Exception;	
	public List<Vendor> getVendors(String vendorType, int vendorNumber, String vendorName, String server, int start, int limit) throws Exception;
	public List<Color> getColors(int colorCode, String colorDescription, String server, int start, int limit) throws Exception;
	public List<Size> getSizes(String sizeCode, String sizeDescription, String server, int start, int limit) throws Exception;
	public List<MerchandiseGroup> getMerchandiseGroups(String merchandiseGroupCode, String merchandiseGroupDescription, String server, int start, int limit) throws Exception;
	public List<PriceGroup> getPriceGroups(String priceGroupCode, String priceGroupDescription, String server, int start, int limit) throws Exception;
	public List<Store> getStores(String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber, String server, int start, int limit) throws Exception;
	public List<Store> getEventStores(int priceEvent, String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber, String server, int start, int limit) throws Exception;	
	public List<Zone> getZones(int zoneNumber, String zoneName, String server, int start, int limit) throws Exception;
	public List<StateProvince> getStates(String country, String server, int start, int limit) throws Exception;	
	
	public String formatHierarchyCriteria(String level, int department, int subDepartment, int classa, String description);	
	public String formatVendorsCriteria(String vendorType, int vendorNumber, String vendorName);
	public String formatColorsCriteria(int colorCode, String colorDescription);
	public String formatSizesCriteria(String sizeCode, String sizeDescription);
	public String formatMerchandiseGroupsCriteria(String merchandiseGroupCode, String merchandiseGroupDescription);
	public String formatPriceGroupsCriteria(String priceGroupCode, String priceGroupDescription);
	public String formatStoresCriteria(String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber);
	public String formatZonesCriteria(int zoneNumber, String zoneName);
	public String formatStatesCriteria(String country);
	public String formatSkuLookupCriteria(Long groupNumber, int department, int subDepartment , int classa, int vendor , String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String itemStatus);
	public String formatProductGroupLookupCriteria(Long groupNumber, String description);	
	public String getHierarchyName(String hierarchyLevel, int department, int subDepartment, int classa, String server) throws Exception;
	public String getVendorName(int vendorNumber, String server) throws Exception;
	public String getStoreName(int storeNumber, String server) throws Exception;
	public String getZoneName(int zoneNumber, String server) throws Exception;        
	public String formatSql(String sql, String orderBy, int start, int limit);
	public int getRowCount(String sql, String server) throws Exception;
	
	public Map getLookupSkus(int departmentNumber, int subDepartmentNumber, int classNumber, int vendorNumber, String vendorPartNumber, Long skuNumber, Long upcNumber, String skuDescription, String statuses, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getHierarchy(String action, int departmentNumber, int subDepartmentNumber, int classNumber, String hierarchyName, String sortFields, String existenceColumn, String appendToWhrClause, int start, int limit, String server) throws Exception;		
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception;
	public Map getTitles(String action, String server) throws Exception;
	public Map getManagers(String action, String title, String server) throws Exception;
	public Map getConcepts(String existenceColumn, String appendToWhrClause, String server) throws Exception;
	public Map getInvCal(String inputDate, String server) throws Exception;
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception;
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getZones(int zoneNumber, String zoneName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getRegions(int regionNumber, String regionName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
    public Map getDistricts(int districtNumber, int regionNumber, String districtName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;	
	public Map getPriceEvents(String eventType, int eventNumber, String eventDescription, int startDate, String eventStatuses, String sortFields, int start, int limit, String server) throws Exception;
	public Map getCodes(String codeType, String code, String codeDescription, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception;
	public Map getVendors(int vendorNumber, String vendorName, String vendorType, String scacCode, String sortFields, String existenceColumn,  String appendToWhrClause, int start, int limit, String server) throws Exception;
	
}
