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

public class Usp_Manager_By_Title_Store_Distro  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Manager_By_Title_Store_Distro(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Manager_By_Title_Store_Distro");
		
		RowMapper rowMapper = new PriceEventRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_action" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_title" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_manager_Name" , Types.VARCHAR));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}

	// Get Titles
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String action) {
		
		Map inParms = new HashMap();

		inParms.put("p_action"       , action);
		inParms.put("p_title"        , "");
		inParms.put("p_manager_Name" , "");
		inParms.put("SQL_STATUS"     , 0);
		inParms.put("SQL_MSGID"      , 0);
		inParms.put("SQL_MSGTXT"     , "");
		Map out = execute(inParms);
		
		return out;		
		
	}

	// Get Manager Names
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String action, String title) {
		
		Map inParms = new HashMap();

		inParms.put("p_action"        , action);
		inParms.put("p_title"         , title);
		inParms.put("p_manager_Name"  , "");
		inParms.put("SQL_STATUS"      , 0);
		inParms.put("SQL_MSGID"       , 0);
		inParms.put("SQL_MSGTXT"      , "");
		Map out = execute(inParms);
		
		return out;		
		
	}


	// Get Stores
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String action, String title, String manager) {
		
		Map inParms = new HashMap();

		inParms.put("p_action"       , action);
		inParms.put("p_title"        , title);
		inParms.put("p_manager_Name" , manager);
		inParms.put("SQL_STATUS"     , 0);
		inParms.put("SQL_MSGID"      , 0);
		inParms.put("SQL_MSGTXT"     , "");
		Map out = execute(inParms);
		
		return out;		
		
	}

	
	
}
