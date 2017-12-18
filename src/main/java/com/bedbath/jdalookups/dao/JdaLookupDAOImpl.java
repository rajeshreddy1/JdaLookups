package com.bedbath.jdalookups.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bedbath.common.util.GetDataSource;
import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;

@Repository
public class JdaLookupDAOImpl implements JdaLookupDAO {
	
	public List<SkuLookup> getLookupSkus(String sql, String server) throws Exception {	

		List<SkuLookup> skuLookup = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		skuLookup =  select.query(sql, new SkuLookupRowMapper());
		return skuLookup;
	}
	
	public List<ProductGroupHeader> getLookupProductGroups(String sql, String server) throws Exception {	

		List<ProductGroupHeader> groupHeader = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		groupHeader =  select.query(sql, new ProductGroupHeaderRowMapper());
		return groupHeader;
	}
		 
	public List<Hierarchy> getHierarchy(String sql, String server) throws Exception {	

		List<Hierarchy> hierarchy = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		hierarchy =  select.query(sql, new HierarchyRowMapper());
		return hierarchy;
	}
		
	public List<Vendor> getVendors(String sql, String server) throws Exception {	

		List<Vendor> vendors = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		vendors =  select.query(sql, new VendorRowMapper());
		return vendors;
	}
		
	public List<Color> getColors(String sql, String server) throws Exception {	

		List<Color> colors = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		colors =  select.query(sql, new ColorRowMapper());
		return colors;
	}
	
	public List<Size> getSizes(String sql, String server) throws Exception {	

		List<Size> sizes = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		sizes =  select.query(sql, new SizeRowMapper());
		return sizes;
	}
	
	public List<MerchandiseGroup> getMerchandiseGroups(String sql, String server) throws Exception {	

		List<MerchandiseGroup> merchandiseGroups = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		merchandiseGroups =  select.query(sql, new MerchandiseGroupRowMapper());
		return merchandiseGroups;
	}

	
	public List<PriceGroup> getPriceGroups(String sql, String server) throws Exception {	

		List<PriceGroup> priceGroups = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		priceGroups =  select.query(sql, new PriceGroupRowMapper());
		return priceGroups;
	}
	
	public Map getHierarchy(String action, int departmentNumber, int subDepartmentNumber, int classNumber, String hierarchyName, String sortFields, String existenceColumn, String appendToWhrClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Hierarchy_Search hierarchySearch = new Usp_Hierarchy_Search(select);
		return hierarchySearch.getResults(action, departmentNumber, subDepartmentNumber, classNumber, hierarchyName, sortFields, existenceColumn, appendToWhrClause, start, limit);
				
	}
	
	public Map getLookupSkus(int departmentNumber, int subDepartmentNumber, int classNumber, int vendorNumber, String vendorPartNumber, Long skuNumber, Long upcNumber, String skuDescription, String statuses, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Sku_Search skuSearch = new Usp_Sku_Search(select);
		return skuSearch.getResults(departmentNumber, subDepartmentNumber, classNumber, vendorNumber, vendorPartNumber, skuNumber, upcNumber, skuDescription, statuses, colorCode, sizeCode, merchandiseGroup, priceGroup, sortFields, existenceColumn, appendToWhereClause, start, limit);
				
	}
	
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Tblfld_Result_Set tblfld = new Usp_Tblfld_Result_Set(select);
		return tblfld.getResults(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);
				
	}
	
	public Map getCampaigns(int campaignId, String campaignName, String sortField, int start, int limit, String server) throws Exception {

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Pace_Evtmgr_Evtsum_Selection campaigns = new Usp_Pace_Evtmgr_Evtsum_Selection(select);
		return campaigns.getResults(campaignId, campaignName, sortField, start, limit);
				
	}

	public Map getTitles(String action, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Manager_By_Title_Store_Distro manager = new Usp_Manager_By_Title_Store_Distro(select, action);
		return manager.getResults(action); 
				
	}

	public Map getManagers(String action, String title, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Manager_By_Title_Store_Distro manager = new Usp_Manager_By_Title_Store_Distro(select, action);
		return manager.getResults(action, title); 
				
	}
	
	public Map getInvCal(String inputDate, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Get_Jda_InvCal invcal = new Usp_Get_Jda_InvCal(select);
		return invcal.getResults(inputDate, server);
				
	}	

	public Map getConcepts(String existenceColumn, String appendToWhrClause, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Concept_Result_Set concepts = new Usp_Concept_Result_Set(select);
		return concepts.getResults(existenceColumn, appendToWhrClause); 
				
	}
		
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Get_User_Level_BBSUSRM bbsusrm = new Usp_Get_User_Level_BBSUSRM(select);
		return bbsusrm.getResults(user, applicationCode, store, server);
				
	}	
	
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		 
		Usp_Store_Search stores = new Usp_Store_Search(select);
		return stores.getResults(zoneNumber, storeNumber, storeName, state, city, storeType, priceEvent, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}
	
	public List<Store> getStores(String sql, String server) throws Exception {	

		List<Store> stores = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
						
        stores =  select.query(sql, new StoreRowMapper());		
		
		return stores;
	}
	
	public List<Zone> getZones(String sql, String server) throws Exception {	

		List<Zone> zones = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		zones =  select.query(sql, new ZoneRowMapper());
		return zones;
	}

	public Map getZones(int zoneNumber, String zoneName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Zone_Search zoneSearch = new Usp_Zone_Search(select);
		return zoneSearch.getResults(zoneNumber, zoneName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}


	public Map getRegions(int regionNumber, String regionName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Region_Search regionSearch = new Usp_Region_Search(select);
		return regionSearch.getResults(regionNumber, regionName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}


	public Map getDistricts(int districtNumber, int regionNumber, String districtName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_District_Search districtSearch = new Usp_District_Search(select);
		return districtSearch.getResults(districtNumber, regionNumber, districtName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}

	public Map getPriceEvents(String eventType, int eventNumber, String eventDescription, int startDate, String eventStatus, String sortFields, int start, int limit, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Price_Event_Search priceEventSearch = new Usp_Price_Event_Search(select);
		return priceEventSearch.getResults(eventType, eventNumber, eventDescription, startDate, eventStatus, sortFields, start, limit, server);
				
	}

	public Map getCodes(String codeType, String code, String codeDescription, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Jda_Code_Search codeSearch = new Usp_Jda_Code_Search(select, codeType);
		return codeSearch.getResults(codeType, code, codeDescription, sortFields, existenceColumn, appendToWhereClause, start, limit);				
	}


	public Map getVendors(int vendorNumber, String vendorName, String vendorType, String scacCode,  String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {	

		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Vendor_Search vendorSearch = new Usp_Vendor_Search(select);
		return vendorSearch.getResults(vendorNumber, vendorName, vendorType, scacCode, sortFields, existenceColumn, appendToWhereClause, start, limit, server);				
	}
	
	public List<StateProvince> getStates(String sql, String server) throws Exception {	

		List<StateProvince> states = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		states =  select.query(sql, new StateProvinceRowMapper());
		return states;
	}
		
	public String getLookupName(String sql, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		String name = "**NOT FOUND**";
		
		List<Map<String, Object>> byteMe = select.queryForList(sql);		
		if(byteMe.size()>0){
			name = (String)byteMe.get(0).get("NAME");	
		} 
				
		return name;			
		
	}
	
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, Long numValue2, Long numValue3, String documentPath, String note1, String note2, String sequenceName, String user, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Bbsappvalu_Maintenance appValue = new Usp_Bbsappvalu_Maintenance(select);
		Map zz = appValue.getResults(action, updateKeys, updateFields, applicationKey, charValue1, charValue2, charValue3, numValue1, numValue2, numValue3, documentPath, note1, note2, sequenceName, user, server);
		
		return zz;
	}

	
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, String numValue2String, int numValue2Length, Long numValue3, String documentPath, String note1, String note2, String sequenceName, String user, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		Usp_Bbsappvalu_Maintenance appValue = new Usp_Bbsappvalu_Maintenance(select);
		Map zz = appValue.getResults(action, updateKeys, updateFields, applicationKey, charValue1, charValue2, charValue3, numValue1, numValue2String, numValue2Length, numValue3, documentPath, note1, note2, sequenceName, user, server);
		
		return zz;
	}	
	
}
