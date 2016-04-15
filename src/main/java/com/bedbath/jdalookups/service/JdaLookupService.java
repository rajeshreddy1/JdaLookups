package com.bedbath.jdalookups.service;

import java.util.List;

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
	public String formatSkuLookupCriteria(Long groupNumber, int department, int subDepartment , int classa, int vendor , String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String itemStatus);
	public List<ProductGroupHeader> getLookupProductGroups(Long groupNumber, String description, String server, int start, int limit) throws Exception;
	
	public List<Hierarchy> getHierarchy(String level, int department, int subDepartment, int classa, String description, String server, int start, int limit) throws Exception;	
	public List<Vendor> getVendors(String vendorType, int vendorNumber, String vendorName, String server, int start, int limit) throws Exception;
	public List<Color> getColors(int colorCode, String colorDescription, String server, int start, int limit) throws Exception;
	public List<Size> getSizes(String sizeCode, String sizeDescription, String server, int start, int limit) throws Exception;
	public List<MerchandiseGroup> getMerchandiseGroups(String merchandiseGroupCode, String merchandiseGroupDescription, String server, int start, int limit) throws Exception;
	public List<PriceGroup> getPriceGroups(String priceGroupCode, String priceGroupDescription, String server, int start, int limit) throws Exception;
	public List<Store> getStores(String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber, String server, int start, int limit) throws Exception;
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
		
	public List<TblFld> getTblFldEntries(String key, String server) throws Exception;
	public String formatProductGroupLookupCriteria(Long groupNumber, String description);	
	public String getHierarchyName(String hierarchyLevel, int department, int subDepartment, int classa, String server) throws Exception;
	public String getVendorName(int vendorNumber, String server) throws Exception;
	public String getStoreName(int storeNumber, String server) throws Exception;
	public String getZoneName(int zoneNumber, String server) throws Exception;
        
	public String formatSql(String sql, String orderBy, int start, int limit);
	public int getRowCount(String sql, String server) throws Exception;
	
}
