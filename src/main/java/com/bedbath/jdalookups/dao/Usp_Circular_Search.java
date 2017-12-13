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

public class Usp_Circular_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Circular_Search(JdbcTemplate jdbcTemplate, String action) {
		
		super(jdbcTemplate, "Usp_Circular_Search");
		
		RowMapper rowMapper=null;
		
		switch(action) {
		
		case "header" :
			rowMapper = new CircularHeaderRowMapper();
			break;
			
		case "detail" :
			rowMapper = new CircularDetailRowMapper();
			break;
		
		}
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_action" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_circular_Id" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_circular_Name" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_circular_Type" , Types.CHAR));
		declareParameter(new SqlParameter("p_in_Home_Date" , Types.CHAR));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_append_To_Whr_Clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(Long circularId, String circularName, String circularType, String inHomeDate, String sortFields, String appendToWhereClause, int start, int limit) {
		
		Map inParms = new HashMap();

		inParms.put("p_action"               , "header");
		inParms.put("p_circular_Id"          , circularId);
		inParms.put("p_circular_Name"        , circularName);
		inParms.put("p_circular_Type"        , circularType);
		inParms.put("p_in_Home_Date"         , inHomeDate);
		inParms.put("p_sort_Fields"          , sortFields);
		inParms.put("p_append_To_Whr_Clause" , appendToWhereClause);
		
		inParms.put("p_offset_Row"           , start);
		inParms.put("p_number_Of_Rows"       , limit);
		inParms.put("SQL_STATUS"             , 0);
		inParms.put("SQL_MSGID"              , 0);
		inParms.put("SQL_MSGTXT"             , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(Long circularId, String circularName, String sortFields, String appendToWhereClause, int start, int limit) {

		Map inParms = new HashMap();

		inParms.put("p_action"               , "header");
		inParms.put("p_circular_Id"          , circularId);
		inParms.put("p_circular_Name"        , circularName);
		inParms.put("p_circular_Type"        , "");
		inParms.put("p_in_Home_Date"         , "");
		inParms.put("p_sort_Fields"          , sortFields);
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
