package com.bedbath.jdalookups.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bedbath.jdalookups.model.BbsAppValuReq;
import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MasterEvtGenerator;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuCount;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.SkuOrUpcSearchReq;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;
import com.bedbath.jdalookups.model.WebAppStatusReq;

@Repository
public class JdaLookupDAOImpl extends JdbcDaoSupport implements JdaLookupDAO {
	
    @Autowired
    public JdaLookupDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
	public List<SkuLookup> getLookupSkus(String sql, String server) throws Exception {	

		List<SkuLookup> skuLookup = new ArrayList();
		skuLookup =  this.getJdbcTemplate().query(sql, new SkuLookupRowMapper());
		return skuLookup;
	}
	
	public List<ProductGroupHeader> getLookupProductGroups(String sql, String server) throws Exception {	

		List<ProductGroupHeader> groupHeader = new ArrayList();
		groupHeader =  this.getJdbcTemplate().query(sql, new ProductGroupHeaderRowMapper());
		return groupHeader;
	}
		 
	public List<Hierarchy> getHierarchy(String sql, String server) throws Exception {	

		List<Hierarchy> hierarchy = new ArrayList();
		hierarchy =  this.getJdbcTemplate().query(sql, new HierarchyRowMapper());
		return hierarchy;
	}
		
	public List<Vendor> getVendors(String sql, String server) throws Exception {	

		List<Vendor> vendors = new ArrayList();
		vendors =  this.getJdbcTemplate().query(sql, new VendorRowMapper());
		return vendors;
	}
		
	public List<Color> getColors(String sql, String server) throws Exception {	

		List<Color> colors = new ArrayList();
		colors =  this.getJdbcTemplate().query(sql, new ColorRowMapper());
		return colors;
	}
	
	public List<Size> getSizes(String sql, String server) throws Exception {	

		List<Size> sizes = new ArrayList();		
		sizes =  this.getJdbcTemplate().query(sql, new SizeRowMapper());
		return sizes;
	}
	
	public List<MerchandiseGroup> getMerchandiseGroups(String sql, String server) throws Exception {	

		List<MerchandiseGroup> merchandiseGroups = new ArrayList();
		merchandiseGroups =  this.getJdbcTemplate().query(sql, new MerchandiseGroupRowMapper());
		return merchandiseGroups;
	}

	
	public List<PriceGroup> getPriceGroups(String sql, String server) throws Exception {	

		List<PriceGroup> priceGroups = new ArrayList();
		priceGroups =  this.getJdbcTemplate().query(sql, new PriceGroupRowMapper());
		return priceGroups;
	}
	
	public Map getHierarchy(String action, int departmentNumber, int subDepartmentNumber, int classNumber, String hierarchyName, String sortFields, String existenceColumn, String appendToWhrClause, int start, int limit, String server) throws Exception {
		 
		Usp_Hierarchy_Search hierarchySearch = new Usp_Hierarchy_Search(this.getJdbcTemplate());
		return hierarchySearch.getResults(action, departmentNumber, subDepartmentNumber, classNumber, hierarchyName, sortFields, existenceColumn, appendToWhrClause, start, limit);
				
	}
	
	public Map getLookupSkus(int departmentNumber, int subDepartmentNumber, int classNumber, int vendorNumber, String vendorPartNumber, Long skuNumber, Long upcNumber, String skuDescription, String statuses, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		 
		Usp_Sku_Search skuSearch = new Usp_Sku_Search(this.getJdbcTemplate());
		return skuSearch.getResults(departmentNumber, subDepartmentNumber, classNumber, vendorNumber, vendorPartNumber, skuNumber, upcNumber, skuDescription, statuses, colorCode, sizeCode, merchandiseGroup, priceGroup, sortFields, existenceColumn, appendToWhereClause, start, limit);
				
	}
	
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception {	
		 
		Usp_Tblfld_Result_Set tblfld = new Usp_Tblfld_Result_Set(this.getJdbcTemplate());
		return tblfld.getResults(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);
				
	}
	
	public Map gettblfldInnersltentries(String action, String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception {	
		 
		Usp_Tblfld_Innerslt_Result_Set tblfld = new Usp_Tblfld_Innerslt_Result_Set(this.getJdbcTemplate());
		return tblfld.getResults(action, keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);
				
	}
	
	public Map getTblFldReasons(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception {	
		 
		Usp_Tblfld_Pcrsn_Result_Set tblfld = new Usp_Tblfld_Pcrsn_Result_Set(this.getJdbcTemplate());
		return tblfld.getResults(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);
				
	}
	
	public Map getNextMstEvntNum(String sql_statement, String server) throws Exception {	
		 
		Usp_Generic_Sql_Result_Set tblfld = new Usp_Generic_Sql_Result_Set(this.getJdbcTemplate(), "nextmstevt");
		return tblfld.getResults(sql_statement);
				
	}
	
	public Map getCampaigns(int campaignId, String campaignName, String sortField, int start, int limit, String server) throws Exception {
		 
		Usp_Pace_Evtmgr_Evtsum_Selection campaigns = new Usp_Pace_Evtmgr_Evtsum_Selection(this.getJdbcTemplate());
		return campaigns.getResults(campaignId, campaignName, sortField, start, limit);
				
	}

	public Map getTitles(String action, String server) throws Exception {	
		 
		Usp_Manager_By_Title_Store_Distro manager = new Usp_Manager_By_Title_Store_Distro(this.getJdbcTemplate(), action);
		return manager.getResults(action); 
				
	}

	public Map getManagers(String action, String title, String server) throws Exception {	
		 
		Usp_Manager_By_Title_Store_Distro manager = new Usp_Manager_By_Title_Store_Distro(this.getJdbcTemplate(), action);
		return manager.getResults(action, title); 
				
	}
	
	public Map getInvCal(String inputDate, String server) throws Exception {	
		 
		Usp_Get_Jda_InvCal invcal = new Usp_Get_Jda_InvCal(this.getJdbcTemplate());
		return invcal.getResults(inputDate, server);
				
	}	

	public Map getConcepts(String existenceColumn, String appendToWhrClause, String server) throws Exception {	
		 
		Usp_Concept_Result_Set concepts = new Usp_Concept_Result_Set(this.getJdbcTemplate());
		return concepts.getResults(existenceColumn, appendToWhrClause); 
				
	}
		
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception {	
		 
		Usp_Get_User_Level_BBSUSRM bbsusrm = new Usp_Get_User_Level_BBSUSRM(this.getJdbcTemplate());
		return bbsusrm.getResults(user, applicationCode, store, server);
				
	}	
	
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		 
		Usp_Store_Search stores = new Usp_Store_Search(this.getJdbcTemplate());
		return stores.getResults(zoneNumber, storeNumber, storeName, state, city, storeType, priceEvent, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}
	
	public List<Store> getStores(String sql, String server) throws Exception {	

		List<Store> stores = new ArrayList();						
        stores =  this.getJdbcTemplate().query(sql, new StoreRowMapper());		
		
		return stores;
	}
	
	public List<Zone> getZones(String sql, String server) throws Exception {	

		List<Zone> zones = new ArrayList();
		zones =  this.getJdbcTemplate().query(sql, new ZoneRowMapper());
		return zones;
	}

	public Map getZones(int zoneNumber, String zoneName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Zone_Search zoneSearch = new Usp_Zone_Search(this.getJdbcTemplate());
		return zoneSearch.getResults(zoneNumber, zoneName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}


	public Map getRegions(int regionNumber, String regionName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Region_Search regionSearch = new Usp_Region_Search(this.getJdbcTemplate());
		return regionSearch.getResults(regionNumber, regionName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}


	public Map getDistricts(int districtNumber, int regionNumber, String districtName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_District_Search districtSearch = new Usp_District_Search(this.getJdbcTemplate());
		return districtSearch.getResults(districtNumber, regionNumber, districtName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}

	public Map getBuyers(String buyerNumber, String buyerName, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Buyer_Search buyerSearch = new Usp_Buyer_Search(this.getJdbcTemplate());
		return buyerSearch.getResults(buyerNumber, buyerName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
				
	}
	
	public Map getPriceEvents(String eventType, /*int*/ String eventNumber, String eventDescription, int startDate, String eventStatus, String sortFields, int start, int limit, String server) throws Exception {
		
		Usp_Price_Event_Search priceEventSearch = new Usp_Price_Event_Search(this.getJdbcTemplate());
		return priceEventSearch.getResults(eventType, eventNumber, eventDescription, startDate, eventStatus, sortFields, start, limit, server);
				
	}

	public Map getCodes(String codeType, String code, String codeDescription, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Jda_Code_Search codeSearch = new Usp_Jda_Code_Search(this.getJdbcTemplate(), codeType);
		return codeSearch.getResults(codeType, code, codeDescription, sortFields, existenceColumn, appendToWhereClause, start, limit);				
	}


	public Map getVendors(int vendorNumber, String vendorName, String vendorType, String scacCode,  String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Vendor_Search vendorSearch = new Usp_Vendor_Search(this.getJdbcTemplate());
		return vendorSearch.getResults(vendorNumber, vendorName, vendorType, scacCode, sortFields, existenceColumn, appendToWhereClause, start, limit, server);				
	}
	
	public Map getCircularHeaders(String action, Long circularId, String circularName, String circularType, String inHomeDate, String sortFields, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Circular_Search circularSearch = new Usp_Circular_Search(this.getJdbcTemplate(), action);
		return circularSearch.getResults(circularId, circularName, circularType, inHomeDate, sortFields, appendToWhereClause, start, limit);			
	}
	
	public Map getMasterEventHeaders(String masterEventNumber, String eventDescription, String startDate, String eventTypes, String applicationId, String sortFields, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		Usp_Pace_Master_Event_Search eventSearch = new Usp_Pace_Master_Event_Search(this.getJdbcTemplate());
		return eventSearch.getResults(masterEventNumber, eventDescription, startDate, eventTypes, applicationId, sortFields, appendToWhereClause, start, limit);			
	}
		
	public Map getStoreBracketHeaders(int bracketNumber, String bracketDescription, String bracketSource, String bracketType, String sortFields, int start, int limit, String server) throws Exception {
		
		Usp_Pace_Store_Bracket_Hdr_Selection bracketSearch = new Usp_Pace_Store_Bracket_Hdr_Selection(this.getJdbcTemplate());
		return bracketSearch.getResults(bracketNumber, bracketDescription, bracketSource, bracketType, sortFields, start, limit);			
	}

	public List<StateProvince> getStates(String sql, String server) throws Exception {	

		List<StateProvince> states = new ArrayList();
		states =  this.getJdbcTemplate().query(sql, new StateProvinceRowMapper());
		return states;
	}
		 
	public String getLookupName(String sql, String server) throws Exception {
		
		String name = "**NOT FOUND**";		
		List<Map<String, Object>> byteMe = this.getJdbcTemplate().queryForList(sql);		
		if(byteMe.size()>0){
			name = (String)byteMe.get(0).get("NAME");	
		} 
				
		return name;			
		
	}
	
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, Long numValue2, Long numValue3, String documentPath, String note1, String note2, String sequenceName, String user, String server) throws Exception {
		
		Usp_Bbsappvalu_Maintenance appValue = new Usp_Bbsappvalu_Maintenance(this.getJdbcTemplate());
		Map zz = appValue.getResults(action, updateKeys, updateFields, applicationKey, charValue1, charValue2, charValue3, numValue1, numValue2, numValue3, documentPath, note1, note2, sequenceName, user, server);
		
		return zz;
	}

	
	public Map maintainApplicationTableValues(String action, String updateKeys, String updateFields, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, String numValue2String, int numValue2Length, Long numValue3, String documentPath, String note1, String note2, String sequenceName, String user, String server) throws Exception {
		
		Usp_Bbsappvalu_Maintenance appValue = new Usp_Bbsappvalu_Maintenance(this.getJdbcTemplate());
		Map zz = appValue.getResults(action, updateKeys, updateFields, applicationKey, charValue1, charValue2, charValue3, numValue1, numValue2String, numValue2Length, numValue3, documentPath, note1, note2, sequenceName, user, server);
		
		return zz;
	}
	
	public Map<String, ? extends Object> searchPdmAttribute(String type, String code, String description, String server, int start, int limit, boolean feature) throws Exception {
		
		if(type.equalsIgnoreCase("ecom brand")) {
			
			Usp_Ecom_Brand_Search pdmAttr = new Usp_Ecom_Brand_Search(this.getJdbcTemplate());
			return pdmAttr.getResults(type, description, server, start, limit);
			
		} else if(type.equalsIgnoreCase("eph")) {
			
			Usp_Eph_Search pdmAttr = new Usp_Eph_Search(this.getJdbcTemplate());
			return pdmAttr.getResults(type, description, server, start, limit);
			
		} else if(type.equalsIgnoreCase("product type")) {
			
			Usp_PRD_TYP pdmAttr = new Usp_PRD_TYP(this.getJdbcTemplate());
			return pdmAttr.getResults(description, code, server, start, limit);
			
		} else if(feature) {
			
			Usp_Ftr_Pdm pdmAttr = new Usp_Ftr_Pdm(this.getJdbcTemplate());
			return pdmAttr.getResults(type, description, server, start, limit); 
			
		} else {
			
			Usp_Att_Pdm pdmAttr = new Usp_Att_Pdm(this.getJdbcTemplate());
			return pdmAttr.getResults(type, description, server, start, limit);
		}
	}
	
	public Map<String, ? extends Object> getBbsUsrmUsers(String action, String sqlStatement, String server) throws Exception {
		
		Usp_Generic_Sql_Result_Set sql = new Usp_Generic_Sql_Result_Set(this.getJdbcTemplate(), action);
		return sql.getResults(sqlStatement);
				
	}
	
	public Map<String, ? extends Object> getRowCount(String action, String sqlStatement, String server) throws Exception {
		
		Usp_Generic_Sql_Result_Set sql = new Usp_Generic_Sql_Result_Set(this.getJdbcTemplate(), action);
		return sql.getResults(sqlStatement);
				
	}
	
	public Map<String, ? extends Object> searchSkuOrUpc(SkuOrUpcSearchReq req) throws Exception {
		
		Usp_Sku_Upc_Search sku = new Usp_Sku_Upc_Search(this.getJdbcTemplate());
		return sku.getResults(req);
	}
		
	@Override
	public Map<String, ? extends Object> WebAppStatusReq(WebAppStatusReq req)
			throws Exception {
		
		Usp_Web_App_Status status = new Usp_Web_App_Status(this.getJdbcTemplate());
		return status.getResults(req);
	}

	@Override
	public Map<String, ? extends Object> getSkuCount(SkuCount req) throws Exception {
		
		Usp_PmsPacDtl_Record_Count result = new Usp_PmsPacDtl_Record_Count(this.getJdbcTemplate());
		return result.getCount(req);
	}

	@Override
	public Map<String, ? extends Object> getNextMasterEvtNum(MasterEvtGenerator req) throws Exception {
		
		Usp_Next_Sequence_Number result = new Usp_Next_Sequence_Number(this.getJdbcTemplate());
		return result.getNextSeq(req);
	}
	
	public Map<String, ? extends Object> getBbsAppValu(BbsAppValuReq req) throws Exception {
		
		Usp_BbsAppValu_Search appValues = new Usp_BbsAppValu_Search(this.getJdbcTemplate());
		return appValues.getResults(req);
	}
	

}
