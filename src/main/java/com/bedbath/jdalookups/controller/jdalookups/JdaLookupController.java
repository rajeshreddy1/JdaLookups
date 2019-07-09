package com.bedbath.jdalookups.controller.jdalookups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bedbath.common.util.CreateExceptionMap;
import com.bedbath.jdalookups.model.BbsAppValuReq;
import com.bedbath.jdalookups.model.BbsAppValuRes;
import com.bedbath.jdalookups.model.BbsUsrm;
import com.bedbath.jdalookups.model.BbsUsrmRes;
import com.bedbath.jdalookups.model.BbsUsrmUser;
import com.bedbath.jdalookups.model.Buyer;
import com.bedbath.jdalookups.model.Campaign;
import com.bedbath.jdalookups.model.CircularHeader;
import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Concept;
import com.bedbath.jdalookups.model.Count;
import com.bedbath.jdalookups.model.District;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.HierarchyNew;
import com.bedbath.jdalookups.model.Manager;
import com.bedbath.jdalookups.model.MasterEventHeader;
import com.bedbath.jdalookups.model.MasterEvtGenerator;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.MixMatchCategory;
import com.bedbath.jdalookups.model.MstrEvntNum;
import com.bedbath.jdalookups.model.PdmAttribute;
import com.bedbath.jdalookups.model.PriceEvent;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Region;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuCount;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.SkuOrUpcSearchReq;
import com.bedbath.jdalookups.model.SkuOrUpcSearchRes;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.StoreBracketHeader;
import com.bedbath.jdalookups.model.TblFld;
import com.bedbath.jdalookups.model.Title;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.WebAppStatusReq;
import com.bedbath.jdalookups.model.WebAppStatusRes;
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

	// Retrieves Campaign Id's that are not in Campaign header file
	@RequestMapping(value = "/jdalookups/campaignslookup.action")
	public @ResponseBody 
	Map<String, ? extends Object> getCampaigns(
			@RequestParam(value = "campaignId", required = false, defaultValue = "0") int campaignId,
			@RequestParam (value = "campaignName", required = false, defaultValue = "") String campaignName,
			@RequestParam (value = "sortFields", required = false, defaultValue = "") String sortField,
			@RequestParam int start,
			@RequestParam int limit,			
			@RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getCampaigns(campaignId, campaignName, sortField, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getCampaigns" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<Campaign> campaigns = new ArrayList();
				campaigns.addAll((Collection<? extends Campaign>) map.get("RESULT_LIST"));

				modelMap.put("data", campaigns);

				if(campaigns.size()>0) {
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
			@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue,
			@RequestParam(value = "searchDescription", required = false, defaultValue = "") String searchDescription,
			@RequestParam(value = "ignoreBlankValue", required = false, defaultValue = "Y") String ignoreBlankValue,
			@RequestParam(value = "sortField", required = false, defaultValue = "TBLDSC") String sortField,
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
				modelMap.put("exception","NoException");
				return modelMap;																					

			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}	
	
	@RequestMapping(value = "/jdalookups/gettblfldInnersltentries.action")
	public @ResponseBody 
	Map<String, ? extends Object> gettblfldInnersltentries(@RequestParam String action,
			@RequestParam String keyValue,
			@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue,
			@RequestParam(value = "searchDescription", required = false, defaultValue = "") String searchDescription,
			@RequestParam(value = "ignoreBlankValue", required = false, defaultValue = "Y") String ignoreBlankValue,
			@RequestParam(value = "sortField", required = false, defaultValue = "TBLDSC") String sortField,
			@RequestParam String server,
			@RequestParam int limit,
			@RequestParam int start
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.gettblfldInnersltentries(action, keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);

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
	
	
	@RequestMapping(value = "/jdalookups/getTblFldReasons.action")
	public @ResponseBody 
	Map<String, ? extends Object> getTblFldReasons(@RequestParam String keyValue,
			@RequestParam(value = "searchValue", required = false, defaultValue = "") String searchValue,
			@RequestParam(value = "searchDescription", required = false, defaultValue = "") String searchDescription,
			@RequestParam(value = "ignoreBlankValue", required = false, defaultValue = "Y") String ignoreBlankValue,
			@RequestParam(value = "sortField", required = false, defaultValue = "") String sortField,
			@RequestParam String server,
			@RequestParam int limit,
			@RequestParam int start
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getTblFldReasons(keyValue, searchValue, searchDescription, ignoreBlankValue, sortField, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getTblFldReasons" + " - " + sqlErrText);
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
				modelMap.put("exception","NoException");
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
	}
	
	@RequestMapping(value = "/jdalookups/getbbsusrmusers.action")
	public @ResponseBody
	Map<String, ? extends Object> getBbsUsrmUsers(@RequestParam String action,
			                                      @RequestParam String sqlStatement,
			                                      @RequestParam String server) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getBbsUsrmUsers(action, sqlStatement, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getBbsUsrmUsers" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<BbsUsrmUser> users = new ArrayList();
				users.addAll((Collection<? extends BbsUsrmUser>) map.get("RESULT_LIST"));
								
				modelMap.put("data", users);
				
				if(users.size()>0) {
					modelMap.put("total", 1);	
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

	
	@RequestMapping(value = "/jdalookups/getrowcount.action")
	public @ResponseBody
	Map<String, ? extends Object> getRowCount(@RequestParam String action,
			                                      @RequestParam String sqlStatement,
			                                      @RequestParam String server) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		
		try {
			
			Map map = jdaLookupService.getRowCount(action, sqlStatement, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getGetRowCount" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<Count> count = new ArrayList();
				count.addAll((Collection<? extends Count>) map.get("RESULT_LIST"));
								
				modelMap.put("data", count);												
				modelMap.put("success", true);			
				return modelMap;																					
								
			}									

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
		
	@RequestMapping(value = "/jdalookups/getNextMstEvntNum.action")
	public @ResponseBody 
	Map<String, ? extends Object> getNextMstEvntNum(
			@RequestParam(value = "sql_statement") String sql_statement,
			@RequestParam String server
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			
			Map map = jdaLookupService.getNextMstEvntNum(sql_statement, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getNextMstEvntNum" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<MstrEvntNum> mstrEvntNum = new ArrayList();
				mstrEvntNum.addAll((Collection<? extends MstrEvntNum>) map.get("RESULT_LIST"));
								
				modelMap.put("data", mstrEvntNum);
				
				if(mstrEvntNum.size()>0) {
					modelMap.put("total", 1);	
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
			//@RequestParam int eventNumber,
			@RequestParam String eventNumber,
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
			@RequestParam(value = "department", required = false, defaultValue = "0") int departmentNumber,
			@RequestParam(value = "subDepartment", required = false, defaultValue = "0") int subDepartmentNumber,
			@RequestParam(value = "classa", required = false, defaultValue = "0") int classNumber,
			@RequestParam(value = "vendor", required = false, defaultValue = "0") int vendorNumber,			
			@RequestParam(value = "partNumber", required = false, defaultValue = "") String vendorPartNumber,
			@RequestParam(value = "skuNumber", required = false, defaultValue = "0") Long skuNumber,
			@RequestParam(value = "upcNumber", required = false, defaultValue = "0") Long upcNumber,
			@RequestParam(value = "skuDescription", required = false, defaultValue = "") String skuDescription,			
			@RequestParam(value = "statuses", required = false, defaultValue = "") String statuses,
			@RequestParam(value = "colorCode", required = false, defaultValue = "0") int colorCode,
			@RequestParam(value = "sizeCode", required = false, defaultValue = "") String sizeCode,
			@RequestParam(value = "merchandiseGroup", required = false, defaultValue = "") String merchandiseGroup,
			@RequestParam(value = "priceGroup", required = false, defaultValue = "") String priceGroup,
			@RequestParam(value = "sortFields", required = false, defaultValue = "INUMBR") String sortFields,			
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
	Map<String, ? extends Object> getZones(							               
			@RequestParam(value = "zoneNumber", required = false,  defaultValue = "0") int zoneNumber,
			@RequestParam(value = "zoneName", required = false,  defaultValue = "") String zoneName,
			@RequestParam(value = "sortFields", required = false,  defaultValue = "ZONNUM") String sortFields,
			@RequestParam(value = "existenceColumn", required = false,  defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false,  defaultValue = "") String appendToWhereClause,
			@RequestParam String server,
			@RequestParam(value = "start", required = false,  defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false,  defaultValue = "200") int limit) {

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


	@RequestMapping(value = "/jdalookups/getbuyers.action")
	public @ResponseBody
	Map<String, ? extends Object> getBuyers(							               
			@RequestParam(value = "buyerNumber", required = false,  defaultValue = "") String buyerNumber,
			@RequestParam(value = "zoneName", required = false,  defaultValue = "") String buyerName,
			@RequestParam(value = "sortFields", required = false,  defaultValue = "BYRNAM") String sortFields,
			@RequestParam(value = "existenceColumn", required = false,  defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false,  defaultValue = "") String appendToWhereClause,
			@RequestParam String server,
			@RequestParam(value = "start", required = false,  defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false,  defaultValue = "500") int limit) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getBuyers(buyerNumber, buyerName, sortFields, existenceColumn, appendToWhereClause, start, limit, server);

			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getBuyers" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<Buyer> buyers = new ArrayList();
				buyers.addAll((Collection<? extends Buyer>) map.get("RESULT_LIST"));

				modelMap.put("data", buyers);

				if(buyers.size()>0) {
					modelMap.put("total", buyers.get(0).getTotalRows());	
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
	Map<String, ? extends Object> getStores(					
			@RequestParam(value = "storeNumber", required = false,  defaultValue = "0") int storeNumber,
			@RequestParam(value = "storeName", required = false, defaultValue = "") String storeName,			                                 
			@RequestParam(value = "city", required = false, defaultValue = "") String city,
			@RequestParam(value = "state", required = false, defaultValue = "") String state,
			@RequestParam(value = "zoneNumber", required = false, defaultValue = "0") int zoneNumber,
			@RequestParam(value = "storeType", required = false, defaultValue = "S") String storeType,
			@RequestParam(value = "priceEvent", required = false, defaultValue = "0") int priceEvent,
			@RequestParam(value = "sortFields", required = false, defaultValue = "STRNUM")  String sortFields,
			@RequestParam(value = "existenceColumn", required = false, defaultValue = "")  String existenceColumn,	
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "")  String appendToWhereClause,
			@RequestParam String server,
			@RequestParam(value = "start", required = false, defaultValue = "0")  int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1")  int limit) {

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


	@RequestMapping(value = "/jdalookups/getvendorsnew.action")
	public @ResponseBody
	Map<String, ? extends Object> getVendors(
			@RequestParam(value = "vendorNumber", required = false, defaultValue = "0") int vendorNumber,
			@RequestParam(value = "vendorName", required = false, defaultValue = "") String vendorName,
			@RequestParam(value = "vendorType", required = false, defaultValue = "") String vendorType,
			@RequestParam(value = "scacCode", required = false, defaultValue = "") String scacCode,			
			@RequestParam(value = "sortFields", required = false, defaultValue = "ASNAME") String sortFields,			
			@RequestParam(value = "existenceColumn", required = false, defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhrClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server									
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getVendors(vendorNumber, vendorName, vendorType, scacCode, sortFields, existenceColumn, appendToWhrClause, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getVendors" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<Vendor> vendor = new ArrayList();
				vendor.addAll( (Collection<? extends Vendor>) map.get("RESULT_LIST"));

				modelMap.put("data", vendor);

				if(vendor.size()>0) {
					modelMap.put("total", vendor.get(0).getTotalRows());
				} else {
					modelMap.put("total", 0);
				}
			}

			return modelMap;

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}

	}

	@RequestMapping(value = "/jdalookups/getcircularheaders.action")
	public @ResponseBody
	Map<String, ? extends Object> getCircularHeaders(
			@RequestParam String action,
			@RequestParam(value = "circularId", required = false, defaultValue = "0") Long circularId,
			@RequestParam(value = "circularName", required = false, defaultValue = "") String circularName,
			@RequestParam(value = "circularType", required = false, defaultValue = "") String circularType,
			@RequestParam(value = "inHomeDate", required = false, defaultValue = "") String inHomeDate,
			@RequestParam(value = "sortFields", required = false, defaultValue = "a.Circular_Id|Circular_Id") String sortFields,			
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server									
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getCircularHeaders(action, circularId, circularName, circularType, inHomeDate, sortFields, appendToWhereClause, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getCircularHeaders" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<CircularHeader> circular = new ArrayList();
				circular.addAll( (Collection<? extends CircularHeader>) map.get("RESULT_LIST"));

				modelMap.put("data", circular);

				if(circular.size()>0) {
					modelMap.put("total", circular.get(0).getTotalRows());
				} else {
					modelMap.put("total", 0);
				}
			}

			return modelMap;

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}

	}

	@RequestMapping(value = "/jdalookups/getmastereventheaders.action")
	public @ResponseBody
	Map<String, ? extends Object> getMasterEventHeaders(
			@RequestParam(value = "masterEventNumber", required = false, defaultValue = "") String masterEventNumber,
			@RequestParam(value = "eventDescription", required = false, defaultValue = "") String eventDescription,
			@RequestParam(value = "applicationId", required = false, defaultValue = "") String applicationId,
			@RequestParam(value = "eventType", required = false, defaultValue = "") String eventTypes,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "sortFields", required = false, defaultValue = "Master_Event_Number") String sortFields,			
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server									
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getMasterEventHeaders(masterEventNumber, eventDescription, startDate, eventTypes, applicationId, sortFields, appendToWhereClause, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getMasterEventHeaders" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<MasterEventHeader> master = new ArrayList();
				master.addAll( (Collection<? extends MasterEventHeader>) map.get("RESULT_LIST"));

				modelMap.put("data", master);

				if(master.size()>0) {
					modelMap.put("total", master.get(0).getTotalRows());
				} else {
					modelMap.put("total", 0);
				}
			}

			return modelMap;

		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}

	}

	@RequestMapping(value = "/jdalookups/getstorebracketheaders.action")
	public @ResponseBody
	Map<String, ? extends Object> getStoreBracketHeaders(
			@RequestParam(value = "bracketNumber", required = false, defaultValue = "0") int bracketNumber,
			@RequestParam(value = "bracketDescription", required = false, defaultValue = "") String bracketDescription,
			@RequestParam(value = "bracketSource", required = false, defaultValue = "") String bracketSource,
			@RequestParam(value = "bracketType", required = false, defaultValue = "") String bracketType,
			@RequestParam(value = "sortFields", required = false, defaultValue = "Store_Bracket_Number") String sortFields,					
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server									
			) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);

		try {

			Map map = jdaLookupService.getStoreBracketHeaders(bracketNumber, bracketDescription, bracketSource, bracketType, sortFields, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {

				String sqlMsgId = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getStoreBracketHeaders" + " - " + sqlErrText);
				return modelMap;

			} else {

				List<StoreBracketHeader> bracket = new ArrayList();
				bracket.addAll( (Collection<? extends StoreBracketHeader>) map.get("RESULT_LIST"));

				modelMap.put("data", bracket);

				if(bracket.size()>0) {
					modelMap.put("total", bracket.get(0).getTotalRows());
				} else {
					modelMap.put("total", 0);
				}
			}

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
			@RequestParam(value = "sortFields", required = false, defaultValue = "Department,SubDepartment,Class") String sortFields,			
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

	// Color , Merchandise Group , Price Group , Size Codes

	@RequestMapping(value = "/jdalookups/getcodes.action")
	public @ResponseBody 
	Map<String, ? extends Object> getCodes(
			@RequestParam String codeType,
			@RequestParam(value = "code", required = false, defaultValue = "") String code,
			@RequestParam(value = "codeDescription", required = false, defaultValue = "") String codeDescription,
			@RequestParam(value = "sortFields", required = false, defaultValue = "") String sortFields,			
			@RequestParam(value = "existenceColumn", required = false, defaultValue = "") String existenceColumn,
			@RequestParam(value = "appendToWhereClause", required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
			@RequestParam String server) throws Exception {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);				

		try {

			Map map = jdaLookupService.getCodes(codeType, code, codeDescription, sortFields, existenceColumn, appendToWhereClause, start, limit, server);
			int sqlStatus = Integer.parseInt(map.get("SQL_STATUS").toString());  

			if(sqlStatus!=0) {

				String sqlMsgId   = map.get("SQL_STATUS").toString();
				String sqlErrText = map.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getCodes" + " - " + sqlErrText);
				return modelMap;

			} else {

				switch(codeType) {

				case "color" :
					List<Color> color = new ArrayList();
					color.addAll((Collection<? extends Color>) map.get("RESULT_LIST"));
					modelMap.put("data", color);
					if(color.size()>0) {
						modelMap.put("total", color.get(0).getTotalRows());
					} else {
						modelMap.put("total", 0);
					}

					break;

				case "size" :
					List<Size> size = new ArrayList();
					size.addAll((Collection<? extends Size>) map.get("RESULT_LIST"));
					modelMap.put("data", size);
					if(size.size()>0) {
						modelMap.put("total", size.get(0).getTotalRows());
					} else {
						modelMap.put("total", 0);
					}

					break;

				case "pattern" :
					List<MerchandiseGroup> merchandiseGroup = new ArrayList();
					merchandiseGroup.addAll((Collection<? extends MerchandiseGroup>) map.get("RESULT_LIST"));
					modelMap.put("data", merchandiseGroup);
					if(merchandiseGroup.size()>0) {
						modelMap.put("total", merchandiseGroup.get(0).getTotalRows());
					} else {
						modelMap.put("total", 0);
					}

					break;

				case "pricegroup" :
					List<PriceGroup> priceGroup = new ArrayList();
					priceGroup.addAll((Collection<? extends PriceGroup>) map.get("RESULT_LIST"));
					modelMap.put("data", priceGroup);
					if(priceGroup.size()>0) {
						modelMap.put("total", priceGroup.get(0).getTotalRows());
					} else {
						modelMap.put("total", 0);
					}

					break;


				case "mixmatch" :
					List<MixMatchCategory> mixMatchCategory = new ArrayList();
					mixMatchCategory.addAll((Collection<? extends MixMatchCategory>) map.get("RESULT_LIST"));
					modelMap.put("data", mixMatchCategory);
					if(mixMatchCategory.size()>0) {
						modelMap.put("total", mixMatchCategory.get(0).getTotalRows());
					} else {
						modelMap.put("total", 0);
					}

					break;

					
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
	
	@RequestMapping(value = "/jdalookups/searchPdmAttribute.action")
	public @ResponseBody 
	Map<String, ? extends Object> searchPdmAttribute(@RequestParam String type,
			@RequestParam(value = "code", required = false, defaultValue = "") String code,
			@RequestParam(value = "description", required = false, defaultValue = "") String description,
			@RequestParam String server,
			@RequestParam int start,
			@RequestParam int limit,
			@RequestParam(value = "feature", required = false, defaultValue = "false") boolean feature
			) throws Exception {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);	
		
		try {
			
			Map<String, ? extends Object> resMap = jdaLookupService.searchPdmAttribute(type, code, description, server, start, limit, feature);
			int sqlStatus = Integer.parseInt(resMap.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {			

				String sqlErrText = resMap.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "LookupController.searchPdmAttribute" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<PdmAttribute> attributes = (List<PdmAttribute>) resMap.get("RESULT_LIST");
				
				modelMap.put("data", attributes);															
				modelMap.put("success", true);
				if(attributes.size()>0) {
					modelMap.put("total", attributes.get(0).getTotal());	
				} else {
					modelMap.put("total", 0);
				}
				return modelMap;																									
			}				
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
	
	@RequestMapping(value = "/jdalookups/searchSkuOrUpc.action", method = RequestMethod.POST) 
	public @ResponseBody Map<String, ? extends Object> searchSkuOrUpc(@ModelAttribute SkuOrUpcSearchReq req) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);	
		
		try {
			
			Map<String, ? extends Object> resMap = jdaLookupService.searchSkuOrUpc(req);
			int sqlStatus = Integer.parseInt(resMap.get("SQL_STATUS").toString());

			if(sqlStatus!=0) {			

				String sqlErrText = resMap.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "LookupController.searchSkuOrUpc" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<SkuOrUpcSearchRes> attributes = (List<SkuOrUpcSearchRes>) resMap.get("RESULT_LIST");
				
				modelMap.put("data", attributes);															
				modelMap.put("success", true);
				if(attributes.size() > 0) {
					modelMap.put("total", attributes.get(0).getTotal());	
				} else {
					modelMap.put("total", 0);
				}
				return modelMap;																									
			}				
			
		} catch(Exception e) {
			return createMap.getExceptionMap(e);
		}
				
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/jdalookups/getBbsAppValu.action")
	public @ResponseBody 
	Map<String, ? extends Object> getBbsAppValu(
			
			@RequestParam(value = "appKey"          , required = true) String appKey,            
			@RequestParam(value = "charVal1"   , required = false, defaultValue = "") String charVal1, 
			@RequestParam(value = "charVal2"   , required = false, defaultValue = "") String charVal2,
			@RequestParam(value = "charVal3"   , required = false, defaultValue = "") String charVal3,						
			@RequestParam(value = "numVal1"    , required = false, defaultValue = "0") Long numVal1,  
			@RequestParam(value = "numVal2"    , required = false, defaultValue = "0") Long numVal2,
			@RequestParam(value = "numVal3"    , required = false, defaultValue = "0") Long numVal3,
			@RequestParam(value = "documentPath"   , required = false, defaultValue = "") String documentPath,
			@RequestParam(value = "note1"   , required = false, defaultValue = "") String note1,
			@RequestParam(value = "note2"   , required = false, defaultValue = "") String note2,
			@RequestParam(value = "sortFields"   , required = false, defaultValue = "") String sortFields,
			@RequestParam(value = "appendToWhereClause"   , required = false, defaultValue = "") String appendToWhereClause,
			@RequestParam(value = "distinctResult"   , required = false, defaultValue = "") String distinctResult,
			@RequestParam int start,
			@RequestParam int limit,
			@RequestParam String server) {	
	
		    BbsAppValuReq req = new BbsAppValuReq();
		    req.setAppKey(appKey);
		    req.setCharVal1(charVal1);
		    req.setCharVal2(charVal2);
		    req.setCharVal3(charVal3);
		    req.setNumVal1(numVal1);
		    req.setNumVal2(numVal2);
		    req.setNumVal3(numVal3);
		    req.setDocumentPath(documentPath);
		    req.setNote1(note1);
		    req.setNote2(note2);
		    req.setSortFields(sortFields);
		    req.setAppendToWhereClause(appendToWhereClause);
		    req.setDistinctResult(distinctResult);
		    req.setStart(start);
		    req.setLimit(limit);
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);	
		
		try {
			
			Map<String, ? extends Object> workMap = jdaLookupService.getBbsAppValu(req);
			int sqlStatus = Integer.parseInt(workMap.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				String sqlErrText = workMap.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getBbsAppValu" + " - " + sqlErrText);				
				return modelMap;						
			} else {
				
				List<BbsAppValuRes> appValueResSet = (List<BbsAppValuRes>) workMap.get("RESULT_LIST");
				modelMap.put("data", appValueResSet);
				if(appValueResSet.size() > 0) {
					modelMap.put("total", appValueResSet.get(0).getTotalRows());	
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
	
	@RequestMapping(value = "/jdalookups/getWebAppStatus.action", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> getWebAppStatus(@ModelAttribute WebAppStatusReq req){
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		
		try {
			Map<String, ? extends Object> resMap = jdaLookupService.WebAppStatusReq(req);
			int sqlStatus = Integer.parseInt(resMap.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {			

				String sqlErrText = resMap.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupController.getWebAppStatus" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				
				List<WebAppStatusRes> attributes = (List<WebAppStatusRes>) resMap.get("RESULT_LIST");
				
				modelMap.put("data", attributes);															
				modelMap.put("success", true);
				return modelMap;																									
			}				
		} catch (Exception e) {
			return createMap.getExceptionMap(e);
		}
	}
	
	@RequestMapping(value = "/jdalookups/getskucount.action", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> getSkuCount(@ModelAttribute SkuCount req){
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		try{
			Map result = jdaLookupService.getSkuCount(req);
			int sqlStatus = Integer.parseInt(result.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = result.get("SQL_STATUS").toString();
				String sqlErrText = result.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getSkuCount" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				int total = Integer.parseInt(result.get("p_recordcount").toString());
				modelMap.put("data", total);												
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
		} catch (Exception e){
			return createMap.getExceptionMap(e);
		}
		
	}
	
	@RequestMapping(value = "/jdalookups/getNextMasterEvntNum.action", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, ? extends Object> getNextMasterEvtNum(@ModelAttribute MasterEvtGenerator req){
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		try{
			Map result = jdaLookupService.getNextMasterEvtNum(req);
			int sqlStatus = Integer.parseInt(result.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = result.get("SQL_STATUS").toString();
				String sqlErrText = result.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getNextMasterEvtNum" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				int nextMasterSeq = Integer.parseInt(result.get("p_nextseqno").toString());
				modelMap.put("data", nextMasterSeq);												
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
		} catch (Exception e){
			return createMap.getExceptionMap(e);
		}
		
	}

	@RequestMapping(value = "/jdalookups/getusersecurity.action", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, ? extends Object> getUserSecurity(@ModelAttribute BbsUsrm req){
		
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		try{
			Map result = jdaLookupService.getUserSecurity(req);
			int sqlStatus = Integer.parseInt(result.get("SQL_STATUS").toString());
			
			if(sqlStatus!=0) {
				
				String sqlMsgId   = result.get("SQL_STATUS").toString();
				String sqlErrText = result.get("SQL_MSGTXT").toString();
				modelMap.put("success", false);
				modelMap.put("exception", "JdaLookupContoller.getUserSecurity" + " - " + sqlErrText);
				return modelMap;
				
			} else {
				List<BbsUsrmRes> userSecurity = (List<BbsUsrmRes>) result.get("RESULT_LIST");
				
				modelMap.put("data", userSecurity);												
				modelMap.put("success", true);			
				return modelMap;																					
								
			}
		} catch (Exception e){
			return createMap.getExceptionMap(e);
		}
		
	}

}
