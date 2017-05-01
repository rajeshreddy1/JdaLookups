package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class Usp_Sku_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Sku_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Sku_Search");
		
		RowMapper rowMapper = new SkuLookupRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		     
		declareParameter(new SqlParameter("p_department_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_sub_department_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_class_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_vendor_Number" , Types.NUMERIC));		
		declareParameter(new SqlParameter("p_vendor_part_Number" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sku_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_upc_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_sku_Description" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_Statuses" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_color_Code" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_size" , Types.CHAR));
		declareParameter(new SqlParameter("p_merchandise_Group" , Types.CHAR));
		declareParameter(new SqlParameter("p_coordinate_Group" , Types.CHAR));
		
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_existence_Column" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_append_To_Whr_Clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(int departmentNumber, int subDepartmentNumber, int classNumber, int vendorNumber, String vendorPartNumber, Long skuNumber, Long upcNumber, String skuDescription, String statuses, int colorCode, String sizeCode, String merchandiseGroup, String priceGroup, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit) {
		
		Map inParms = new HashMap();
  
		inParms.put("p_department_Number"     , departmentNumber);  
		inParms.put("p_sub_department_Number" , subDepartmentNumber);
		inParms.put("p_class_Number"          , classNumber);
		inParms.put("p_vendor_Number"         , vendorNumber); 
		inParms.put("p_vendor_part_Number"    , vendorPartNumber);
        inParms.put("p_sku_Number"            , skuNumber);
		inParms.put("p_upc_Number"            , upcNumber);
		inParms.put("p_sku_Description"       , skuDescription);
		inParms.put("p_Statuses"              , statuses);
		inParms.put("p_color_Code"            , colorCode);
		inParms.put("p_size"                  , sizeCode);
		inParms.put("p_merchandise_Group"     , merchandiseGroup);
		inParms.put("p_coordinate_Group"      , priceGroup);
				
		inParms.put("p_sort_Fields"           , sortFields);
		inParms.put("p_existence_Column"     , existenceColumn);
		inParms.put("p_append_To_Whr_Clause" , appendToWhereClause);
		inParms.put("p_offset_Row"           , start);
		inParms.put("p_number_Of_Rows"       , limit);
		inParms.put("SQL_STATUS"             , 0);
		inParms.put("SQL_MSGID"              , 0);
		inParms.put("SQL_MSGTXT"             , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
