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
import com.bedbath.jdalookups.model.Concept;
import com.bedbath.jdalookups.model.District;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.HierarchyNew;
import com.bedbath.jdalookups.model.Manager;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceEvent;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Region;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.TblFld;
import com.bedbath.jdalookups.model.Title;
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

	@RequestMapping(value = "/jdalookups/titlelookup.action")
	public @ResponseBody 
	Map<String, ? extends Object> getTitles(@RequestParam String action,
			                                       @RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getTitles(action, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getTitles" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Title> title = new ArrayList();
				
				Title all = new Title();
				all.setTitle("*ALL");
				
				title.add(all);								
				title.addAll((Collection<? extends Title>) map.get("RESULT_LIST"));
								
				modelMap.put("data", title);
				
				if(title.size()>0) {
					modelMap.put("total", 0);	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	@RequestMapping(value = "/jdalookups/managerlookup.action")
	public @ResponseBody 
	Map<String, ? extends Object> getManagers(@RequestParam String action,
										      @RequestParam String title,
			                                  @RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getManagers(action, title, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getManagers" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Manager> manager = new ArrayList();
				manager.addAll((Collection<? extends Manager>) map.get("RESULT_LIST"));
								
				modelMap.put("data", manager);
				
				if(manager.size()>0) {
					modelMap.put("total", 0);	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	


	@RequestMapping(value = "/jdalookups/conceptlookup.action")
	public @ResponseBody 
	Map<String, ? extends Object> getConcepts(@RequestParam String existenceColumn, @RequestParam String appendToWhrClause, @RequestParam String includeAll, @RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getConcepts(existenceColumn, appendToWhrClause, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getConcepts" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Concept> concepts = new ArrayList();
				concepts.addAll((Collection<? extends Concept>) map.get("RESULT_LIST"));
		
				if(includeAll.equalsIgnoreCase("Y")) {					
					Concept concept = new Concept();
					concept.setConceptName("*ALL");
					concept.setConceptNumber(0);
					concept.setDnsName("");
					List<Concept> con = new ArrayList();
					con.add(concept);
					con.addAll(concepts);
					modelMap.put("data", con);					
				} else {
					modelMap.put("data", concepts);	
				}
												
				if(concepts.size()>0) {
					modelMap.put("total", 0);	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
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
				
				if(tblfld.size()>0) {
					modelMap.put("total", tblfld.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
								
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


	@RequestMapping(value = "/jdalookups/getuserlevelfrombbsusrm.action")
	public @ResponseBody 
	Map<String, ? extends Object> getUserLevelFromBbsusrm(@RequestParam String user,
			                                			  @RequestParam String applicationCode,
			                                			  @RequestParam int storeNumber,
			                                			  @RequestParam String server
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		
		try {
			
			Map map = jdaLookupService.getUserLevelBbsUsrM(user, applicationCode, storeNumber, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getUserLevelFromBbsusrm" + " - " + sqlErrText);
				return modelMap;
				
			} else {
								 
				modelMap.put("data", map);						
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
				
				if(priceEvents.size()>0) {
					modelMap.put("total", priceEvents.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
				
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	

	@RequestMapping(value = "/jdalookups/getlookupskusnew.action")
	public @ResponseBody 
	Map<String, ? extends Object> getLookupSkus(
			@RequestParam(value = "departmentNumber", required = false, defaultValue = "0") int departmentNumber,
			@RequestParam(value = "subDepartmentNumber", required = false, defaultValue = "0") int subDepartmentNumber,
			@RequestParam(value = "classNumber", required = false, defaultValue = "0") int classNumber,
			@RequestParam(value = "vendorNumber", required = false, defaultValue = "0") int vendorNumber,			
			@RequestParam(value = "vendorPartNumber", required = false, defaultValue = "") String vendorPartNumber,
			@RequestParam(value = "skuNumber", required = false, defaultValue = "0") Long skuNumber,
			@RequestParam(value = "upcNumber", required = false, defaultValue = "0") Long upcNumber,
			@RequestParam(value = "skuDescription", required = false, defaultValue = "") String skuDescription,			
			@RequestParam(value = "statuses", required = false, defaultValue = "") String statuses,
			@RequestParam(value = "colorCode", required = false, defaultValue = "0") int colorCode,
			@RequestParam(value = "sizeCode", required = false, defaultValue = "") String sizeCode,
			@RequestParam(value = "merchandiseGroup", required = false, defaultValue = "") String merchandiseGroup,
			@RequestParam(value = "priceGroup", required = false, defaultValue = "") String priceGroup,
			@RequestParam(value = "sortFields", required = false, defaultValue = "") String sortFields,			
			@RequestParam(value = "existenceColumn", required = false, defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);				
		
		try {
			
			Map map = jdaLookupService.getLookupSkus(departmentNumber, subDepartmentNumber, classNumber, vendorNumber, vendorPartNumber, skuNumber, upcNumber, skuDescription, statuses, colorCode, sizeCode, merchandiseGroup, priceGroup, sortFields, existenceColumn, appendToWhereClause, start, limit, server);			
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());  
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getLookupSkus" + " - " + sqlErrText);
				return modelMap;
								
			} else {

				List<SkuLookup> skuLookup = new ArrayList();		
				skuLookup.addAll((Collection<? extends SkuLookup>) map.get("RESULT_LIST"));
				
				modelMap.put("data", skuLookup);	
				
				if(skuLookup.size()>0) {
					modelMap.put("total", skuLookup.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
				
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

	@RequestMapping(value = "/jdalookups/districtlookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getDistricts(@RequestParam int districtNumber,
			                                  @RequestParam int regionNumber,
			                                  @RequestParam String districtName,
											  @RequestParam String sortFields,
											  @RequestParam String existenceColumn,	
											  @RequestParam String appendToWhereClause,
											  @RequestParam String server,
											  @RequestParam int start,
											  @RequestParam int limit) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getDistricts(districtNumber, regionNumber, districtName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getDistricts" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<District> districts = new ArrayList();
				districts.addAll((Collection<? extends District>) map.get("RESULT_LIST"));
								
				modelMap.put("data", districts);
				
				if(districts.size()>0) {
					modelMap.put("total", districts.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
		
	}

	@RequestMapping(value = "/jdalookups/regionlookup.action")
	public @ResponseBody
	Map<String, ? extends Object> getRegions( @RequestParam int regionNumber,
			                                  @RequestParam String regionName,
											  @RequestParam String sortFields,
											  @RequestParam String existenceColumn,	
											  @RequestParam String appendToWhereClause,
											  @RequestParam String server,
											  @RequestParam int start,
											  @RequestParam int limit) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getRegions(regionNumber, regionName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getRegions" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Region> regions = new ArrayList();
				regions.addAll((Collection<? extends Region>) map.get("RESULT_LIST"));
								
				modelMap.put("data", regions);
				
				if(regions.size()>0) {
					modelMap.put("total", regions.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
		
	}
				
	@RequestMapping(value = "/jdalookups/zonelookupn.action")
	public @ResponseBody
	Map<String, ? extends Object> getZones(@RequestParam int zoneNumber,
			                               @RequestParam String zoneName,
										   @RequestParam String sortFields,
										   @RequestParam String existenceColumn,	
										   @RequestParam String appendToWhereClause,
										   @RequestParam String server,
										   @RequestParam int start,
										   @RequestParam int limit) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getZones(zoneNumber, zoneName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getZones" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Zone> zones = new ArrayList();
				zones.addAll((Collection<? extends Zone>) map.get("RESULT_LIST"));
								
				modelMap.put("data", zones);
				
				if(zones.size()>0) {
					modelMap.put("total", zones.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
		
	}
		
	@RequestMapping(value = "/jdalookups/storelookupn.action")
	public @ResponseBody
	Map<String, ? extends Object> getStores(@RequestParam int storeNumber,
											@RequestParam String storeName,			                                 
			                                 @RequestParam String city,
											 @RequestParam String state,
											 @RequestParam int zoneNumber,
											 @RequestParam String storeType,
											 @RequestParam int priceEvent,
											 @RequestParam String sortFields,
											 @RequestParam String existenceColumn,	
											 @RequestParam String appendToWhereClause,
											 @RequestParam String server,
											 @RequestParam int start,
											 @RequestParam int limit) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getStores(zoneNumber, storeNumber, storeName, state, city, storeType, priceEvent, sortFields, existenceColumn, appendToWhereClause, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getStores" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Store> stores = new ArrayList();
				stores.addAll((Collection<? extends Store>) map.get("RESULT_LIST"));
								
				modelMap.put("data", stores);
				
				if(stores.size()>0) {
					modelMap.put("total", stores.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
								
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

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
											   @RequestParam(value = "subDepartment", required = false, defaultValue = "0") int subDepartment,
											   @RequestParam(value = "classa", required = false, defaultValue = "0") int classa,
											   @RequestParam(value = "description", required = false, defaultValue = "")  String description,
											   @RequestParam String server,
											   @RequestParam(value = "start", required = false, defaultValue = "0")  int start,
											   @RequestParam(value = "limit", required = false, defaultValue = "1")  int limit) {
		
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


	@RequestMapping(value = "/jdalookups/gethierarchynew.action")
	public @ResponseBody 
	Map<String, ? extends Object> getHierarchy(
			@RequestParam String action,
			@RequestParam(value = "departmentNumber", required = false, defaultValue = "0") int departmentNumber,
			@RequestParam(value = "subDepartmentNumber", required = false, defaultValue = "0") int subDepartmentNumber,
			@RequestParam(value = "classNumber", required = false, defaultValue = "0") int classNumber,
			@RequestParam(value = "hierarchyName", required = false, defaultValue = "") String hierarchyName,			
			@RequestParam(value = "sortFields", required = false, defaultValue = "") String sortFields,			
			@RequestParam(value = "existenceColumn", required = false, defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);				
		
		try {
			
			Map map = jdaLookupService.getHierarchy(action, departmentNumber, subDepartmentNumber, classNumber, hierarchyName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());  
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getHierarchy" + " - " + sqlErrText);
				return modelMap;
								
			} else {

				List<HierarchyNew> hierarchy = new ArrayList();		
				hierarchy.addAll((Collection<? extends HierarchyNew>) map.get("RESULT_LIST"));
				
				modelMap.put("data", hierarchy);	
				
				if(hierarchy.size()>0) {
					modelMap.put("total", hierarchy.get(0).getTotalRows());	
				} else {
					modelMap.put("total", 0);
				}
				
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
			
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
