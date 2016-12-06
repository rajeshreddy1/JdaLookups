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

public class Usp_Tblfld_Result_Set  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Tblfld_Result_Set(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Tblfld_Result_Set");
		
		RowMapper rowMapper = new TblFldRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_key_Value" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_search_Value" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_search_Description" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_ignore_Blank_Value" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Field" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String keyValue,String searchValue, String searchDescription, String ignoreBlankValue, String sortField, int start, int limit, String server) {
		
		Map inParms = new HashMap();

		inParms.put("p_key_Value"         , keyValue);
		inParms.put("p_search_Value"      , searchValue);
		inParms.put("p_search_Description", searchDescription);
		inParms.put("p_ignore_Blank_Value", ignoreBlankValue);
		inParms.put("p_sort_Field"        , sortField);
		inParms.put("p_offset_Row"         , start);
		inParms.put("p_number_Of_Rows"    , limit);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
