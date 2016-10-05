package com.bedbath.jdalookups.controller.jdalookups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedbath.common.util.CreateExceptionMap;
import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceEvent;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.TblFld;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;
import com.bedbath.jdalookups.service.JdaLookupService;

@Controller
public class JdaLookupController {

	CreateExceptionMap createMap = new CreateExceptionMap();
	
	@Autowired
	public JdaLookupService jdaLookupService;

	@RequestMapping(value = "/jdalookups/gethierarchyname.action")
	public @ResponseBody
	Map<String, ? extends Object> getHierarchyName(@RequestParam String hierarchyLevel,
			@RequestParam int department,
			@RequestParam int subDepartment,
			@RequestParam int classa,
			@RequestParam String server) throws Exception {

		try {

			String hierarchyName = jdaLookupService.getHierarchyName(hierarchyLevel, department, subDepartment, classa, server);

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("hierarchyName", hierarchyName);
			modelMap.put("success", true);
			modelMap.put("exception", "");
			return modelMap;			

		} catch(Exception e) {

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("hierarchyName", "");
			modelMap.put("success", false);
			modelMap.put("exception", e.getClass() + " - " + e.getMessage());
			return modelMap;

		}

	}

	@RequestMapping(value = "/jdalookups/getvendorname.action")
	public @ResponseBody
	Map<String, ? extends Object> getVendorName(@RequestParam int vendorNumber,
			@RequestParam String server) throws Exception {

		try {

			String vendorName = jdaLookupService.getVendorName(vendorNumber, server);

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("vendorName", vendorName);
			modelMap.put("success", true);
			modelMap.put("exception", "");
			return modelMap;			

		} catch(Exception e) {

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("vendorName", "");
			modelMap.put("success", false);
			modelMap.put("exception", e.getClass() + " - " + e.getMessage());
			return modelMap;

		}

	}

	@RequestMapping(value = "/jdalookups/getstorename.action")
	public @ResponseBody
	Map<String, ? extends Object> getStoreName(@RequestParam int storeNumber,
			@RequestParam String server) throws Exception {

		try {

			String storeName = jdaLookupService.getStoreName(storeNumber, server);

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("storeName", storeName);
			modelMap.put("success", true);
			modelMap.put("exception", "");
			return modelMap;			

		} catch(Exception e) {

			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("storeName", "");
			modelMap.put("success", false);
			modelMap.put("exception", e.getClass() + " - " + e.getMessage());
			return modelMap;

		}

	}
	
	@RequestMapping(value = "/jdalookups/gettblfldentries.action")
	public @ResponseBody 
	Map<String, ? extends Object> getTblFldEntries(@RequestParam String keyValue,
			@RequestParam String searchValue,
			@RequestParam String searchDescription,
			@RequestParam String ignoreBlankValue,
			@RequestParam String sortField,
			@RequestParam String server,
			@RequestParam int limit,
			@RequestParam int start
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getTblFldEntries(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getTblFldEntries" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<TblFld> tblfld = new ArrayList();
				tblfld.addAll((Collection<? extends TblFld>) map.get("RESULT_LIST"));
				
				modelMap.put("data", tblfld);						
				modelMap.put("total", map.get("p_result_Count"));
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	@RequestMapping(value = "/jdalookups/getinvcal.action")
	public @ResponseBody 
	Map<String, ? extends Object> getInvCal(@RequestParam String inputDate,
											@RequestParam String server
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getInvCal(inputDate, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getInvCal" + " - " + sqlErrText);
				return modelMap;
				
			} else {
								
				modelMap.put("data", map);						
				modelMap.put("total", map.get("p_result_Count"));
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	
	@RequestMapping(value = "/jdalookups/getpriceevents.action")
	public @ResponseBody 
	Map<String, ? extends Object> getPriceEvents(@RequestParam String eventTypes,
			@RequestParam String eventDescription,
			@RequestParam String eventStatuses,
			@RequestParam int startDate,
			@RequestParam int eventNumber,
			@RequestParam String sortFields,
			@RequestParam String server,
			@RequestParam int limit,
			@RequestParam int start
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);				
		
		try {
			
			Map map = jdaLookupService.getPriceEvents(eventTypes,eventNumber,eventDescription,startDate,eventStatuses,sortFields,start,limit,server);
			
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());  
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getPriceEvents" + " - " + sqlErrText);
				return modelMap;
								
			} else {

				List<PriceEvent> priceEvents = new ArrayList();		
				priceEvents.addAll((Collection<? extends PriceEvent>) map.get("RESULT_LIST"));
				
				modelMap.put("data", priceEvents);						
				modelMap.put("total", map.get("p_result_Count"));
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	
	
	@RequestMapping(value = "/jdalookups/getlookupskus.action")
	public @ResponseBody 
	Map<String, ? extends Object> getLookupSkus(@RequestParam Long groupNumber,
			@RequestParam int department,
			@RequestParam int subDepartment,
			@RequestParam int classa,
			@RequestParam int vendor,
			@RequestParam String partNumber,
			@RequestParam Long skuNumber,
			@RequestParam Long upcNumber,
			@RequestParam String skuDescription,
			@RequestParam String shortDescription,
			@RequestParam int colorCode,
			@RequestParam String sizeCode,
			@RequestParam String merchandiseGroup,
			@RequestParam String priceGroup,
			@RequestParam String itemStatus,
			@RequestParam String server,
			@RequestParam int start,
			@RequestParam int limit
			) throws Exception {

		try {

			List<SkuLookup> skuLookup = new ArrayList();												
			skuLookup = jdaLookupService.getLookupSkus(groupNumber, department, subDepartment, classa, vendor, partNumber, skuNumber, upcNumber, skuDescription, shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup , itemStatus , server, start, limit);			

			return getLookupSkusMap(skuLookup, groupNumber, department, subDepartment, classa, vendor, partNumber, skuNumber, upcNumber, skuDescription, shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup , itemStatus, server);																					

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	@RequestMapping(value = "/jdalookups/getlookupskucount.action")
	public @ResponseBody 
	Map<String, ? extends Object> getLookupSkuCount(@RequestParam Long groupNumber,
			@RequestParam int department,
			@RequestParam int subDepartment,
			@RequestParam int classa,
			@RequestParam int vendor,
			@RequestParam String partNumber,
			@RequestParam Long skuNumber,
			@RequestParam Long upcNumber,
			@RequestParam String skuDescription,
			@RequestParam String shortDescription,
			@RequestParam int colorCode,
			@RequestParam String sizeCode,
			@RequestParam String merchandiseGroup,
			@RequestParam String priceGroup,
			@RequestParam String itemStatus,
			@RequestParam String server
			) throws Exception {

		try {

			Map<String, Object> modelMap = new HashMap<String, Object>(2);

			String sql = "SELECT Count(*) FROM INSVMST INNER JOIN PMPPRCMSC On INSVMST.INUMBR=PMPPRCMSC.PMSKU ";	
			String sqlWhere = jdaLookupService.formatSkuLookupCriteria(groupNumber, department, subDepartment, classa, vendor, partNumber, skuNumber, upcNumber, skuDescription, shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup, itemStatus); 
			sql += sqlWhere + " fetch first 1 rows only";		

			modelMap.put("total", (jdaLookupService.getRowCount(sql,server)));
			modelMap.put("whereClause", jdaLookupService.formatSkuLookupCriteria(groupNumber, department, subDepartment, classa, vendor, partNumber, skuNumber, upcNumber, skuDescription, shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup, itemStatus));
			modelMap.put("success", true);
			return modelMap;

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	private Map<String, Object> getLookupSkusMap(List<SkuLookup> skuLookup, Long groupNumber, int department, int subDepartment, int classa, int vendor, String partNumber, Long skuNumber, Long upcNumber, String skuDescription, String shortDescription, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup , String itemStatus, String server) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		String sql = "SELECT Count(*) FROM INSVMST INNER JOIN PMPPRCMSC On INSVMST.INUMBR=PMPPRCMSC.PMSKU ";	
		String sqlWhere = jdaLookupService.formatSkuLookupCriteria(groupNumber, department, subDepartment, classa, vendor, partNumber, skuNumber, upcNumber, skuDescription, shortDescription, colorCode, sizeCode, merchandiseGroup, priceGroup, itemStatus); 
		sql += sqlWhere + " fetch first 1 rows only";		

		modelMap.put("data", skuLookup);
		modelMap.put("total", (jdaLookupService.getRowCount(sql,server)));
		modelMap.put("success", true);
		return modelMap;
	}

	@RequestMapping(value = "/jdalookups/vendorlookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getVendors(@RequestParam String vendorType,
											 @RequestParam int vendorNumber,
											 @RequestParam String vendorName,
											 @RequestParam String server,
											 @RequestParam int start,
											 @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Vendor> vendors = new ArrayList();
			vendors = jdaLookupService.getVendors(vendorType, vendorNumber, vendorName, server, start, limit);
			
			modelMap.put("data", vendors);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From ApSupp " + jdaLookupService.formatVendorsCriteria(vendorType, vendorNumber, vendorName) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}

	@RequestMapping(value = "/jdalookups/storelookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getStores(@RequestParam String storeType,
			                                 @RequestParam int storeNumber,
											 @RequestParam String storeName,
											 @RequestParam String city,
											 @RequestParam String state,
											 @RequestParam int zoneNumber,
											 @RequestParam String server,
											 @RequestParam int start,
											 @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Store> stores = new ArrayList();
			stores = jdaLookupService.getStores(storeType, storeNumber, storeName, city, state, zoneNumber, server, start, limit);
			
			modelMap.put("data", stores);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From TblStr " + jdaLookupService.formatStoresCriteria(storeType, storeNumber, storeName, city, state, zoneNumber) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {		
			return createMap.getExceptionMap(e);
		}
				
	}

	@RequestMapping(value = "/jdalookups/eventstorelookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getEventStores(@RequestParam int priceEvent,
			                                     @RequestParam String storeType,
			                                     @RequestParam int storeNumber,
										         @RequestParam String storeName,
										         @RequestParam String city,
										         @RequestParam String state,
										         @RequestParam int zoneNumber,
										         @RequestParam String server,
										         @RequestParam int start,
										         @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Store> stores = new ArrayList();
			stores = jdaLookupService.getEventStores(priceEvent, storeType, storeNumber, storeName, city, state, zoneNumber, server, start, limit);
			
			modelMap.put("data", stores);			
			
			modelMap.put("total", jdaLookupService.getRowCount("Call Usp_Store_Search(" + zoneNumber + ",0," + storeNumber + ",'" + storeName + "','','" + state + "','" + city + "','" + storeType + "'," + priceEvent + ",'STRNUM'," + (start+1) + "," + limit + ",'C')", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {		
			return createMap.getExceptionMap(e);
		}
				
	}
	
	@RequestMapping(value = "/jdalookups/zonelookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getZones(@RequestParam int zoneNumber,
											 @RequestParam String zoneName,
											 @RequestParam String server,
											 @RequestParam int start,
											 @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Zone> zones = new ArrayList();
			zones = jdaLookupService.getZones(zoneNumber, zoneName, server, start, limit);
			
			modelMap.put("data", zones);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From IZone " + jdaLookupService.formatZonesCriteria(zoneNumber, zoneName) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}		
		
	}
	
	@RequestMapping(value = "/jdalookups/gethierarchy.action")
	public @ResponseBody
	Map<String, ? extends Object> getHierarchy(@RequestParam String level,
											   @RequestParam int department,
											   @RequestParam int subDepartment,
											   @RequestParam int classa,
											   @RequestParam String description,
											   @RequestParam String server,
											   @RequestParam int start,
											   @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Hierarchy> hierarchy = new ArrayList();
			hierarchy = jdaLookupService.getHierarchy(level, department, subDepartment, classa, description, server, start, limit);
			
			modelMap.put("data", hierarchy);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From InvDpt " + jdaLookupService.formatHierarchyCriteria(level, department, subDepartment, classa, description) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}

	@RequestMapping(value = "/jdalookups/getcolors.action")
	public @ResponseBody
	Map<String, ? extends Object> getColors(@RequestParam int colorCode,
											@RequestParam String colorDescription,
											@RequestParam String server,
											@RequestParam int start,
											@RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Color> colors = new ArrayList();
			colors = jdaLookupService.getColors(colorCode, colorDescription, server, start, limit);
			
			modelMap.put("data", colors);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From TblCol " + jdaLookupService.formatColorsCriteria(colorCode, colorDescription) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}

	@RequestMapping(value = "/jdalookups/getsizes.action")
	public @ResponseBody
	Map<String, ? extends Object> getSizes(@RequestParam String sizeCode,
										   @RequestParam String sizeDescription,
										   @RequestParam String server,
										   @RequestParam int start,
										   @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<Size> sizes = new ArrayList();
			sizes = jdaLookupService.getSizes(sizeCode, sizeDescription, server, start, limit);
			
			modelMap.put("data", sizes);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From TblSiz " + jdaLookupService.formatSizesCriteria(sizeCode, sizeDescription) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}

	@RequestMapping(value = "/jdalookups/getmerchandisegroups.action")
	public @ResponseBody
	Map<String, ? extends Object> getMerchandiseGroups(@RequestParam String merchandiseGroupCode,
										              @RequestParam String merchandiseGroupDescription,
										              @RequestParam String server,
										              @RequestParam int start,
										              @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<MerchandiseGroup> merchandiseGroups = new ArrayList();
			merchandiseGroups = jdaLookupService.getMerchandiseGroups(merchandiseGroupCode, merchandiseGroupDescription, server, start, limit);
			
			modelMap.put("data", merchandiseGroups);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From InvFin " + jdaLookupService.formatMerchandiseGroupsCriteria(merchandiseGroupCode, merchandiseGroupDescription) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
	
	@RequestMapping(value = "/jdalookups/getpricegroups.action")
	public @ResponseBody
	Map<String, ? extends Object> getPriceGroups(@RequestParam String priceGroupCode,
										         @RequestParam String priceGroupDescription,
										         @RequestParam String server,
										         @RequestParam int start,
										         @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<PriceGroup> priceGroups = new ArrayList();
			priceGroups = jdaLookupService.getPriceGroups(priceGroupCode, priceGroupDescription, server, start, limit);
			
			modelMap.put("data", priceGroups);
			modelMap.put("total", jdaLookupService.getRowCount("Select Count(*) From TblCor " + jdaLookupService.formatPriceGroupsCriteria(priceGroupCode, priceGroupDescription) + "fetch first 1 rows only ", server));
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
	
	@RequestMapping(value = "/jdalookups/stateslookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getStates(@RequestParam String country,
											 @RequestParam String server,
											 @RequestParam int start,
											 @RequestParam int limit) {
		
		try {
			
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			
			List<StateProvince> states = new ArrayList();
			states = jdaLookupService.getStates(country, server, start, limit);
			
			modelMap.put("data", states);
			modelMap.put("total", "0");
			modelMap.put("success", true);
			
			return modelMap;
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
	
	@RequestMapping(value = "/jdalookups/getlookupproductgroups.action")
	public @ResponseBody 
	Map<String, ? extends Object> getLookupSkus(@RequestParam Long groupNumber,
			@RequestParam String description,
			@RequestParam String server,
			@RequestParam int start,
			@RequestParam int limit
			) throws Exception {

		try {

			List<ProductGroupHeader> productGroup = new ArrayList();												
			productGroup = jdaLookupService.getLookupProductGroups(groupNumber, description , server, start, limit);			

			return getLookupProductGroupMap(productGroup, groupNumber, description , server);																					

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	private Map<String, Object> getLookupProductGroupMap(List<ProductGroupHeader> productGroup, Long groupNumber, String description, String server) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		String sql = "SELECT Count(*) FROM AMS_Product_Group_Header ";	
		String sqlWhere = jdaLookupService.formatProductGroupLookupCriteria(groupNumber, description); 
		sql += sqlWhere + " fetch first 1 rows only";		

		modelMap.put("data", productGroup);
		modelMap.put("total", (jdaLookupService.getRowCount(sql,server)));
		modelMap.put("success", true);
		return modelMap;
	}

}
