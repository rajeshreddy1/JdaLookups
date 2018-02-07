package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.SkuOrUpcSearchReq;

public class Usp_Sku_Upc_Search  extends StoredProcedure {

	public Usp_Sku_Upc_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Sku_Upc_Search");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new SkuUpcResultSetExtractor()));

		declareParameter(new SqlParameter("P_SKU_OR_UPC",	Types.VARCHAR));	
		declareParameter(new SqlParameter("P_DEPARTMENT",	Types.DECIMAL));	
		declareParameter(new SqlParameter("P_SUB_DEPARTMENT",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_CLASS",	Types.DECIMAL));	
		declareParameter(new SqlParameter("P_COLOR",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_SIZE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_WEB_PRODUCT",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_WEB_COLLECTION",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_SEASONS",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_THEME",	Types.VARCHAR));	
		declareParameter(new SqlParameter("P_REGIONAL",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_LIFESTYLE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_STATUS",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_SKU",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_UPC",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_DESCRIPTION",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_VENDOR",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_VENDOR_PART_NUM",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_VDC",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_VENDOR_COLLECTION",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_VENDOR_STYLE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_ECOM_BRAND",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_PRODUCT_TYPE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_SEARCH_LIST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_MERCH_GROUP",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_PRICE_GROUP",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_RETAIL_LOWEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_RETAIL_HIGHEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_MAP_LOWEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_MAP_HIGHEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_MSRP_LOWEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_MSRP_HIGHEST",	Types.DECIMAL));
		declareParameter(new SqlParameter("P_BUYER",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_EXCLUSIVITY",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_CHEF_CENTRAL",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_PROFILE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_EPH",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_SORT_FIELDS",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_EXISTENCE_COLUMN",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_APPEND_TO_WHR_CLAUSE",	Types.VARCHAR));
		declareParameter(new SqlParameter("P_OFFSET_ROW",	Types.NUMERIC));
		declareParameter(new SqlParameter("P_NUMBER_OF_ROWS",	Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));

		compile();		
	}
	

	public Map<String, ? extends Object> getResults(SkuOrUpcSearchReq req) {
				
		Map<String, Object> inParms = new HashMap<String, Object>();

		inParms.put("P_SKU_OR_UPC",	req.getType());
		inParms.put("P_DEPARTMENT",	req.getDepartment());		
		inParms.put("P_SUB_DEPARTMENT",	req.getSubDepartment());
		inParms.put("P_CLASS",	req.getClassa());
		inParms.put("P_COLOR",	req.getColorCode());
		inParms.put("P_SIZE",	req.getSizeCode());
		inParms.put("P_WEB_PRODUCT", req.getWebProduct());
		inParms.put("P_WEB_COLLECTION",	req.getWebCollection());
		inParms.put("P_SEASONS",	req.getSeason());
		inParms.put("P_THEME",	req.getTheme());
		inParms.put("P_REGIONAL", req.getRegion());
		inParms.put("P_LIFESTYLE",	req.getLifeStyle());
		inParms.put("P_STATUS",	req.getItemStatus());
		inParms.put("P_SKU",	req.getSkuNumber());
		inParms.put("P_UPC",	req.getUpcNumber());
	    inParms.put("P_DESCRIPTION", req.getItemDescription());
	    inParms.put("P_VENDOR",	req.getVendor());
	    inParms.put("P_VENDOR_PART_NUM",	req.getPartNumber());
	    inParms.put("P_VDC",	req.getVdc());
	    inParms.put("P_VENDOR_COLLECTION",	req.getVendorCollection());
	    inParms.put("P_VENDOR_STYLE",	req.getVendorStyle());
	    inParms.put("P_ECOM_BRAND",	req.getEcomBrand());
	    inParms.put("P_PRODUCT_TYPE",	req.getProductType());
	    inParms.put("P_SEARCH_LIST",	req.getListNumber());
	    inParms.put("P_MERCH_GROUP",	req.getMerchandiseGroup());
	    inParms.put("P_PRICE_GROUP",	req.getPriceGroup());
	    inParms.put("P_RETAIL_LOWEST",	req.getRetailFrom());
	    inParms.put("P_RETAIL_HIGHEST",	req.getRetailTo());
	    inParms.put("P_MAP_LOWEST",	req.getMapFrom());
	    inParms.put("P_MAP_HIGHEST",	req.getMapTo());
	    inParms.put("P_MSRP_LOWEST",	req.getMsrpFrom());
	    inParms.put("P_MSRP_HIGHEST",	req.getMsrpTo());
	    inParms.put("P_BUYER",	req.getBuyer());
	    inParms.put("P_EXCLUSIVITY",	req.getExclusivity());
	    inParms.put("P_CHEF_CENTRAL",	req.getChefCentral());
	    inParms.put("P_PROFILE",	req.getProfile());
	    inParms.put("P_EPH",	req.getEph());
	    inParms.put("P_SORT_FIELDS",	"");
	    inParms.put("P_EXISTENCE_COLUMN",	"");
	    inParms.put("P_APPEND_TO_WHR_CLAUSE",	"");
	    inParms.put("P_OFFSET_ROW",	req.getStart());
	    inParms.put("P_NUMBER_OF_ROWS",	req.getLimit());
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID", 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);
		
		return out;						
		
	}	
	
}
