package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.WebAppStatusReq;

public class Usp_Web_App_Status extends StoredProcedure{
	
	public Usp_Web_App_Status(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Web_App_Status");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new WebAppStatusResultSetExtractor()));
		     
		declareParameter(new SqlParameter("p_app_code"     , Types.CHAR));
		declareParameter(new SqlParameter("p_concept"      , Types.CHAR));
		declareParameter(new SqlParameter("p_country"      , Types.CHAR));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID" , Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(WebAppStatusReq req) {
		
		Map inParms = new HashMap();
  
		inParms.put("p_app_code", req.getAppId());  
		inParms.put("p_concept" , req.getConcept());
		inParms.put("p_country" , req.getCountry());
	
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID" , 0);
		inParms.put("SQL_MSGTXT", "");
		Map out = execute(inParms);				
		
		return out;		
		
	}

}
