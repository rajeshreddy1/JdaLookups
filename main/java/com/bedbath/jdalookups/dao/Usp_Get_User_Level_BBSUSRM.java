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

public class Usp_Get_User_Level_BBSUSRM  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Get_User_Level_BBSUSRM(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Get_User_Level_BBSUSRM");
				
		declareParameter(new SqlParameter("p_user" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_application_Code" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_store" , Types.NUMERIC));
		
		declareParameter(new SqlOutParameter("o_user_Level" , Types.NUMERIC));
		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String user, String applicationCode, int store, String server) {
		
		Map inParms = new HashMap();

		inParms.put("p_user" , user);
		inParms.put("p_application_Code" , applicationCode);
		inParms.put("p_store" , store);
    
		inParms.put("o_user_Level" , 0);
		
		inParms.put("SQL_STATUS" , 0);
		inParms.put("SQL_MSGID"  , 0);
		inParms.put("SQL_MSGTXT" , "");
		Map out = execute(inParms);
		
		return out;		
		
	}
	
}
