package com.bedbath.jdalookups.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedbath.common.util.service.UtilityService;
import com.bedbath.jdalookups.dao.JdaLookupDAO;
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

@Service
public class JdaLookupServiceImpl extends UtilityService implements JdaLookupService {
 	
	@Autowired
	private JdaLookupDAO jdaLookupDAO;
			
	public List<SkuLookup> getLookupSkus(Long groupNumber, int department, int subDepartment, int classa, int vendor, String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup , String itemStatus, String server, int start, int limit) throws Exception	{

		String sql="Select INUMBR , Trim(IDESCR) IDESCR , IDSCCD, PMREGU, IDEPT, ISDEPT, ICLAS, ASNUM, IVNDP#, IFINLN, ISCOLR, ICORGP From INSVMST Inner Join PMPPRCMSC On INSVMST.INUMBR=PMPPRCMSC.PMSKU " +				   
				   
				   formatSkuLookupCriteria(groupNumber, department, subDepartment , classa,  vendor , partNumber, skuNumber,  upcNumber,  skuDescription,  shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup, itemStatus);
				
		sql = formatSql(sql, " Order By IDESCR " , start, limit);
		
		return jdaLookupDAO.getLookupSkus(sql,server);

	}	

	public List<ProductGroupHeader> getLookupProductGroups(Long groupNumber, String description, String server, int start, int limit) throws Exception	{

		String sql="Select Product_Group_Number , Trim(Product_Group_Description) Product_Group_Description , Status, Type, Trim(TblDsc) TypeDescription, Create_Date_Time, End_Date From Ams_Product_Group_Header Inner Join TblFld On Ams_Product_Group_Header.Type=TblFld.TblVal And TblFld.TblNam = 'AMSPTP' " +	   
				   
				   formatProductGroupLookupCriteria(groupNumber, description);
				
		sql = formatSql(sql, " Order By Product_Group_Description " , start, limit);
		
		return jdaLookupDAO.getLookupProductGroups(sql,server);

	}	

	public String formatHierarchyCriteria(String level, int department, int subDepartment, int classa, String description) {
		
		String sqlWhere="";
		
		switch(level.toString()) {
		
		case "Department" :
			
			if(!description.equalsIgnoreCase("")) {				
				sqlWhere = "Where Upper(DPTNAM) Like '%" + description + "%' And ISDEPT = 0 ";				
			} else {
				sqlWhere = "Where IDEPT = " + department + " And ISDEPT = 0 ";
			}			
			
			break;
			
		case "SubDepartment" :

			if(!description.equalsIgnoreCase("")) {				
				sqlWhere = "Where IDEPT = " + department + " And Upper(DPTNAM) Like '%" + description + "%' And ISDEPT > 0 And ICLAS = 0 ";
			} else {				
				if(subDepartment!=0) {
					sqlWhere = "Where IDEPT = " + department + " And ISDEPT = " +  subDepartment + " And ICLAS = 0 ";					
				} else {
					sqlWhere = "Where IDEPT = " + department + " And ISDEPT > 0 And ICLAS = 0 ";
				}
				
			} 
							
			break;
			
		case "Class" :

			if(!description.equalsIgnoreCase("")) {				
				sqlWhere = "Where IDEPT = " + department + " And ISDEPT = " + subDepartment + " And Upper(DPTNAM) Like '%" + description + "%' And ICLAS > 0 ";								
			} else {
				
				if(classa!=0) {
					sqlWhere = "Where IDEPT = " + department + " And ISDEPT = " + subDepartment + " And ICLAS = " + classa + " ";					
				} else {
					sqlWhere = "Where IDEPT = " + department + " And ISDEPT = " + subDepartment + " And ICLAS > 0 ";
				}
				
			}
								
			break;
		}

		return sqlWhere;
		
	}
	
	public List<Hierarchy> getHierarchy(String level, int department, int subDepartment, int classa , String description, String server, int start, int limit) throws Exception {
		
		String select = "Select IDEPT, ISDEPT, ICLAS, DPTNAM FROM INVDPT ";
				
		String sql = formatSql(select + formatHierarchyCriteria(level,department,subDepartment,classa,description), " Order By IDEPT, ISDEPT, ICLAS " , start, limit);
		return jdaLookupDAO.getHierarchy(sql, server);
		
	}
		
	public String formatVendorsCriteria(String vendorType, int vendorNumber, String vendorName) {
		
		String sqlWhere = "Where ASTYPE = '" + vendorType + "' ";
		
		if(vendorName!="") {
			sqlWhere += " And ASNAME Like '" + vendorName + "%' ";
		} else {
			sqlWhere += " And ASNUM = " + vendorNumber + " ";
		}
		
		return sqlWhere;

	}
	
	public List<Vendor> getVendors(String vendorType, int vendorNumber, String vendorName, String server, int start, int limit) throws Exception {
	
		String select = "Select ASNUM, ASNAME , ASTYPE , ASBUYR From APSUPP ";		
		
		String sql = formatSql(select + formatVendorsCriteria(vendorType,vendorNumber,vendorName), " Order By ASNAME " , start, limit);
		return jdaLookupDAO.getVendors(sql, server);
		
	}

	public String formatColorsCriteria(int colorCode, String colorDescription) {
		
		String sqlWhere="";
		
		if(colorDescription!="") {
			sqlWhere += "Where UPPER(COLDSC) Like '%" + colorDescription + "%' ";
		} else {
			sqlWhere += "Where COLCOD = " + colorCode + " ";
		}

		return sqlWhere;
		
	}
	
	public List<Color> getColors(int colorCode, String colorDescription, String server, int start, int limit) throws Exception {
		
		String select = "Select COLCOD, COLDSC, COLSHT From TBLCOL ";
		
		String sql = formatSql(select + formatColorsCriteria(colorCode,colorDescription), " Order By COLDSC " , start, limit);
		return jdaLookupDAO.getColors(sql, server);
		
	}

	public String formatSizesCriteria(String sizeCode, String sizeDescription) {
		
		String sqlWhere="";
		
		if(sizeDescription!="") {
			sqlWhere += "Where Upper(SIZDSC) Like '%" + sizeDescription + "%' ";
		} else {
			sqlWhere += "Where SIZCOD = '" + sizeCode + "' ";
		}
		
		return sqlWhere;
		
	}
	
	public List<Size> getSizes(String sizeCode, String sizeDescription, String server, int start, int limit) throws Exception {
		
		String select = "Select SIZCOD, SIZDSC, SIZSHT From TBLSIZ ";
				
		String sql = formatSql(select + formatSizesCriteria(sizeCode,sizeDescription), " Order By SIZDSC " , start, limit);
		return jdaLookupDAO.getSizes(sql, server);
		
	}
	
	public String formatMerchandiseGroupsCriteria(String merchandiseGroupCode, String merchandiseGroupDescription ) {
		
		String sqlWhere="";
		
		if(merchandiseGroupDescription!="") {
			sqlWhere += "Where IFLDSC Like '%" + merchandiseGroupDescription + "%' ";
		} else {
			sqlWhere += "Where IFINLN = '" + merchandiseGroupCode + "' ";
		}

		return sqlWhere;
	}
	
	public List<MerchandiseGroup> getMerchandiseGroups(String merchandiseGroupCode, String merchandiseGroupDescription, String server, int start, int limit) throws Exception {
		
		String select = "Select IFINLN, IFLDSC From INVFIN ";		
		
		String sql = formatSql(select + formatMerchandiseGroupsCriteria(merchandiseGroupCode,merchandiseGroupDescription), " Order By IFLDSC " , start, limit);
		return jdaLookupDAO.getMerchandiseGroups(sql, server);
		
	}
		
	public String formatPriceGroupsCriteria(String priceGroupCode, String priceGroupDescription) {
		
		String sqlWhere="";
		
		if(priceGroupDescription!="") {
			sqlWhere += "Where Upper(CORDSC) Like '%" + priceGroupDescription + "%' ";
		} else {
			sqlWhere += "Where Upper(CORGRP) = " + priceGroupCode;
		}
		
		return sqlWhere;
	}
	
	public List<PriceGroup> getPriceGroups(String priceGroupCode, String priceGroupDescription, String server, int start, int limit) throws Exception {
		
		String select = "Select CORGRP, CORDSC From TBLCOR ";
		String whereClause="";
		
		
		String sql = formatSql(select + formatPriceGroupsCriteria(priceGroupCode, priceGroupDescription), " Order By CORDSC " , start, limit);
		return jdaLookupDAO.getPriceGroups(sql, server);
		
	}		
	
	public Map getZones(int zoneNumber, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		return jdaLookupDAO.getZones(zoneNumber, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
		
	}
	
	public Map getRegions(int regionNumber, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		return jdaLookupDAO.getRegions(regionNumber, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
		
	}
	
	public Map getDistricts(int districtNumber, int regionNumber, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		return jdaLookupDAO.getDistricts(districtNumber, regionNumber, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
		
	}
	
	public Map getTblFldEntries(String keyValue, String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) throws Exception	{

		return jdaLookupDAO.getTblFldEntries(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);
		
	}	

	public Map getTitles(String action, String server) throws Exception {
		
		return jdaLookupDAO.getTitles(action, server);
		
	}

	public Map getManagers(String action, String title, String server) throws Exception {
		
		return jdaLookupDAO.getManagers(action, title, server);
		
	}

	public Map getConcepts(String server) throws Exception {
		
		return jdaLookupDAO.getConcepts(server);
		
	}
	
	public Map getUserLevelBbsUsrM(String user, String applicationCode, int store, String server) throws Exception	{

		return jdaLookupDAO.getUserLevelBbsUsrM(user, applicationCode, store, server);
		
	}	
		
	public Map getInvCal(String inputDate, String server) throws Exception	{

		return jdaLookupDAO.getInvCal(inputDate, server);
		
	}	
		
	public String getHierarchyName(String hierarchyLevel, int department, int subDepartment, int classa, String server) throws Exception {
				
		String sql="";
		if(hierarchyLevel.equalsIgnoreCase("department")) {
			sql = "Select DptNam Name From InvDpt Where IDept = " + department + " And IsDept = 0";
			return jdaLookupDAO.getLookupName(sql, server);
		}

		if(hierarchyLevel.equalsIgnoreCase("subDepartment")) {
			sql = "Select DptNam Name From InvDpt Where IDept = " + department + " And IsDept = " + subDepartment + " And IClas = 0";
			return jdaLookupDAO.getLookupName(sql, server);
		}

		if(hierarchyLevel.equalsIgnoreCase("class")) {
			sql = "Select DptNam Name From InvDpt Where IDept = " + department + " And IsDept = " + subDepartment + " And IClas = " + classa;
			return jdaLookupDAO.getLookupName(sql, server);
		}

		return "";
	}
	
	public String getVendorName(int vendorNumber, String server) throws Exception {
		
		String sql="";
		sql = "Select AsName Name From ApSupp Where AsNum = " + vendorNumber;
		return jdaLookupDAO.getLookupName(sql, server);
	}
	
	public String getStoreName(int storeNumber, String server) throws Exception {
		
		String sql="";
		sql = "Select StrNam Name From TblStr Where StrNum = " + storeNumber;
		return jdaLookupDAO.getLookupName(sql, server);
		
	}
		
	public String getZoneName(int zoneNumber, String server) throws Exception {
		
		String sql="";
		sql = "Select ZonNam Name From IZone Where ZonNum = " + zoneNumber;
		return jdaLookupDAO.getLookupName(sql, server);
		
	}
	
	public String formatProductGroupLookupCriteria(Long groupNumber, String description) {
		
		String sqlWhere="";
		
		if(groupNumber!=0) {			
			sqlWhere="Where Product_Group_Number = " + groupNumber + " ";			
		} else {
			sqlWhere="Where Upper(Product_Group_Description) Like '%" + description + "%' "; 
		}
		
		return sqlWhere;
		
	}
	
	public String formatSkuLookupCriteria(Long groupNumber, int department, int subDepartment, int classa, int vendor, String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String itemStatus) {

		String sqlWhere="";
		if(groupNumber!=0) {
			sqlWhere="INUMBR Not In (Select PRODUCT_GROUP_SKU FROM AMS_PRODUCT_GROUP_DETAIL Where Product_Group_Number = " + groupNumber + ") And INUMBR In (Select INUMBR From INSVUPC) ";	
		}
		
		
		if(skuNumber!=0) {
			if(sqlWhere=="") {
				sqlWhere = "INSVMST.INUMBR = " + skuNumber;
			} else {
				sqlWhere += " AND INSVMST.INUMBR = " + skuNumber;
			}						
		}
		
		if(department!=0) {
			if(sqlWhere=="") {
				sqlWhere = "IDEPT = " + department;
			} else {
				sqlWhere += " AND IDEPT = " + department;
			}						
		}
		
		if(subDepartment!=0) {
			if(sqlWhere=="") {
				sqlWhere = "ISDEPT = " + subDepartment;
			} else {
				sqlWhere += " AND ISDEPT = " + subDepartment;
			}						
		}

		if(classa!=0) {
			if(sqlWhere=="") {
				sqlWhere = "ICLAS = " + classa;
			} else {
				sqlWhere += " AND ICLAS = " + classa;
			}						
		}

		if(vendor!=0) {
			if(sqlWhere=="") {
				sqlWhere = "ASNUM = " + vendor;
			} else {
				sqlWhere += " AND ASNUM = " + vendor;
			}						
		}
		
		if(partNumber!="") {
			if(sqlWhere=="") {
				sqlWhere = "IVNDP# = '" + partNumber + "' ";
			} else {
				sqlWhere += " AND IVNDP# = '" + partNumber + "' ";
			}						
		}		
		
		if(colorCode!=0) {
			if(sqlWhere=="") {
				sqlWhere = "ISCOLR = " + colorCode;
			} else {
				sqlWhere += " AND ISCOLR = " + colorCode;
			}						
		}

		if(skuDescription!="") {
			if(sqlWhere=="") {
				sqlWhere = "IDESCR LIKE '" + skuDescription + "%' ";
			} else {
				sqlWhere += " AND IDESCR LIKE '" + skuDescription + "%' ";
			}						
		}
		
		if(sizeCode!="") {
			if(sqlWhere=="") {
				sqlWhere = "ISSIZE = '" + sizeCode + "' ";
			} else {
				sqlWhere += " AND ISSIZE = '" + sizeCode + "' ";
			}						
		}
		
		if(merchandiseGroup!="") {
			if(sqlWhere=="") {
				sqlWhere = "IFINLN = '" + merchandiseGroup + "' ";
			} else {
				sqlWhere += " AND IFINLN = '" + merchandiseGroup + "' ";
			}						
		}
		
		if(priceGroup!="") {
			if(sqlWhere=="") {
				sqlWhere = "ICORGP = '" + priceGroup + "' ";
			} else {
				sqlWhere += " AND ICORGP = '" + priceGroup + "' ";
			}						
		}

		if(itemStatus!="") {
			if(sqlWhere=="") {
				
				if(!itemStatus.equalsIgnoreCase("Z")) {
					sqlWhere = "IDSCCD = '" + itemStatus + "' ";	
				} else {
					sqlWhere = "IDSCCD <> 'P' ";
				}
								
			} else {
				
				if(!itemStatus.equalsIgnoreCase("Z")) {
					sqlWhere += " AND IDSCCD = '" + itemStatus + "' ";
				} else {
					sqlWhere += " AND IDSCCD <> 'P' ";
				}				
				
			}						
		}
				
		if(sqlWhere=="") {
			return "";
		} else {
			return "Where " + sqlWhere;	
		}
				
	}
	
	public Map getPriceEvents(String eventTypes,int eventNumber,String eventDescription,int startDate,	String eventStatuses,String sortFields,	int start,int limit,String server)	throws Exception {

		return jdaLookupDAO.getPriceEvents(eventTypes, eventNumber, eventDescription, startDate, eventStatuses, sortFields, start, limit, server);
		
	}
			
	public Map getStores(int zoneNumber, int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) throws Exception {
		
		return jdaLookupDAO.getStores(zoneNumber, storeNumber, storeName, state, city, storeType, priceEvent, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
		
	}
	public List<Store> getStores(String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber, String server, int start, int limit) throws Exception	{

		String sql="Select StrNum, Trim(StrNam) StrNam, Trim(StAdd1) StAdd1, Trim(StAdd2) StAdd2, Trim(StAdd3) StAdd3, StPvSt, StZip, StPhon, StCntr, RegNum, StrDst, ZonNum, StCmp, StrTyp, StrHdo From TblStr Inner Join StpCmp On StrNum=StStor  " +	   
				   
				   formatStoresCriteria(storeType, storeNumber, storeName, city, state, zoneNumber);
				
		sql = formatSql(sql, " Order By StrNum " , start, limit);
		
		return jdaLookupDAO.getStores(sql,server);

	}	

	public List<Store> getEventStores(int priceEvent, String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber, String server, int start, int limit) throws Exception	{ 
		
		String sql="Call Usp_Store_Search(" + zoneNumber + ",0," + storeNumber + ",'" + storeName + "','','" + state + "','" + city + "','" + storeType + "'," + priceEvent + ",'STRNUM'," + (start+1) + "," + limit + ",'R')";
		System.out.println(sql);
		
		return jdaLookupDAO.getStores(sql, server);
		
	}
	
	public String formatStoresCriteria(String storeType, int storeNumber, String storeName, String city, String state, int zoneNumber) {
		
		String sqlWhere="";
		
		if(storeType!="") {

			if(sqlWhere=="") {
				sqlWhere = "StrHdo = '" + storeType + "' ";
			} else {
				sqlWhere += "And StrHdo = '" + storeType + "' ";
			}
			
		}

		if(storeNumber!=0) {

			if(sqlWhere=="") {
				sqlWhere = "StrNum =" + storeNumber + " ";
			} else {
				sqlWhere += "And StrNum =" + storeNumber + " ";
			}
			
		}
		
		if(storeName!="") {

			if(sqlWhere=="") {
				sqlWhere = "Upper(StrNam) Like '%" + storeName + "%' ";
			} else {
				sqlWhere += "And Upper(StrNam) Like '%" + storeName + "%' ";
			}
			
		}
		
		if(city!="") {

			if(sqlWhere=="") {
				sqlWhere = "Upper(StAdd3) Like '%" + city + "%' ";
			} else {
				sqlWhere += "And Upper(StAdd3) Like '%" + city + "%' ";
			}
			
		}		
		
		if(state!="") {

			if(sqlWhere=="") {
				sqlWhere = "StPvSt = '" + state + "' ";
			} else {
				sqlWhere += "And StPvSt = '" + state + "' ";
			}
			
		}
			
		if(zoneNumber!=0) {

			if(sqlWhere=="") {
				sqlWhere = "ZonNum =" + zoneNumber + " ";
			} else {
				sqlWhere += "And ZonNum =" + zoneNumber + " ";
			}
			
		}
			
		if(!sqlWhere.equalsIgnoreCase("")) {
			sqlWhere = "Where " + sqlWhere;
		}
		
		return sqlWhere;
		
	}
	
	public List<StateProvince> getStates(String country, String server, int start, int limit) throws Exception {
		
		String sql="Select PrCode, PrName, PrCntr From TblPrv " +
		        
				  formatStatesCriteria(country);
		
		return jdaLookupDAO.getStates(sql, server);
	}
	
	public String formatStatesCriteria(String country) {
		
		String sqlWhere="";
		
		if(country=="") {
			sqlWhere = "Where PrCode In (Select SubStr(SiDept,1,2) From TapSim) ";
		} else {
			sqlWhere = "Where PrCntr = '" + country + "' And PrCode In (Select SubStr(SiDept,1,2) From TapSim) ";   
		}
		
		return sqlWhere;
		
	}
	
	public List<Zone> getZones(int zoneNumber, String zoneName, String server, int start, int limit) throws Exception	{

		String sql="Select ZonNum, ZonNam, ZonSht From IZone  " +	   
				   
				   formatZonesCriteria(zoneNumber, zoneName);
				
		if(limit==0) {
			sql += " Order By ZonNum ";
		} else {
			sql = formatSql(sql, " Order By ZonNum " , start, limit);	
		}
				
		return jdaLookupDAO.getZones(sql,server);

	}	

	public String formatZonesCriteria(int zoneNumber, String zoneName) {
		
		String sqlWhere="";
		
		if(zoneNumber!=0) {			
			sqlWhere="Where ZonNum = " + zoneNumber + " ";			
		}

		if(zoneName!="") {

			if(sqlWhere=="") {
				sqlWhere = "ZonNam Like '%" + zoneName + "%' ";
			} else {
				sqlWhere += "And ZonNam Like '%" + zoneName + "%' ";
			}
			
		}
						
		return sqlWhere;
		
	}
	
}
