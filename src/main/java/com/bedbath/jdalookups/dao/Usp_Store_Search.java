package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.dao.StoreRowMapper;

public class Usp_Store_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Store_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Store_Search");
		
		RowMapper rowMapper = new StoreRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_zone_Number" , Types.NUMERIC));      
		declareParameter(new SqlParameter("p_company_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_store_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_store_Name" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_country_Code" , Types.CHAR));
		declareParameter(new SqlParameter("p_state_Code" , Types.CHAR));
		declareParameter(new SqlParameter("p_city" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_store_Type" , Types.CHAR));
		declareParameter(new SqlParameter("p_price_Event" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_existence_Column" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(int zoneNumber,int storeNumber, String storeName, String state, String city, String storeType, int priceEvent, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit, String server) {
		
		Map inParms = new HashMap();

		inParms.put("p_zone_Number"          , zoneNumber);
		inParms.put("p_company_Number"       , 0);
		inParms.put("p_store_Number"         , storeNumber);
		inParms.put("p_store_Name"           , storeName);
		inParms.put("p_country_Code"         , "");
		inParms.put("p_state_Code"           , state);
		inParms.put("p_city"                 , city);
		inParms.put("p_store_Type"           , storeType);
		inParms.put("p_price_Event"          , priceEvent);
		inParms.put("p_sort_Fields"          , sortFields);
		inParms.put("p_existence_Column"     , existenceColumn);
		inParms.put("p_append_To_Whr_Clause" , existenceColumn);
		
		inParms.put("p_offset_Row"        , start);
		inParms.put("p_number_Of_Rows"    , limit);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
	
}
