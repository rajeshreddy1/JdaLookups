package com.bedbath.jdalookups.dao;

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
import com.bedbath.jdalookups.model.Title;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;

public interface JdaLookupDAO {
	
	public List<SkuLookup> getLookupSkus(String sql, String server) throws Exception;
	public List<ProductGroupHeader> getLookupProductGroups(String sql, String server) throws Exception;
	
	public List<Hierarchy> getHierarchy(String sql, String server) throws Exception;
	public List<Vendor> getVendors(String sql, String server) throws Exception;
	public List<Color> getColors(String sql, String server) throws Exception;
	public List<Size> getSizes(String sql, String server) throws Exception;
	public List<MerchandiseGroup> getMerchandiseGroups(String sql, String server) throws Exception;
	public List<PriceGroup> getPriceGroups(String sql, String server) throws Exception;	
	public Map getTitles(String action, String server) throws Exception;
	public Map getManagers(String action, String title, String server) throws Exception;
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception;
	public Map getConcepts(String server) throws Exception;
	public Map getInvCal(String inputDate, String server) throws Exception;
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception;
	public List<Store> getStores(String sql, String server) throws Exception;
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, int start, int limit, String server) throws Exception;
	public List<Zone> getZones(String sql, String server) throws Exception;
	public List<StateProvince> getStates(String sql, String server) throws Exception;
	public Map getPriceEvents(String eventType, int eventNumber, String eventDescription, int startDate, String eventStatus, String sortFields, int start, int limit, String server) throws Exception;
	public String getLookupName(String sql, String server) throws Exception;
	
			
}
