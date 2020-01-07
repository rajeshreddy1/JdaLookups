package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.BbsUsrm;

public class Usp_User_Security_Master extends StoredProcedure{
	
public Usp_User_Security_Master(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_User_Security_Master");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new UserSecurityResultSetExtractor()));
		     
		declareParameter(new SqlParameter("p_appid"                , Types.CHAR));
		declareParameter(new SqlParameter("p_store"                , Types.NUMERIC));
		declareParameter(new SqlParameter("p_sort_fields"          , Types.VARCHAR));
		declareParameter(new SqlParameter("p_append_to_whr_clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_row"           , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_of_rows"       , Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID" , Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(BbsUsrm req) {
		
		Map inParms = new HashMap();
  
		inParms.put("p_appid"                , req.getAppId());  
		inParms.put("p_store"                , req.getStore());
		inParms.put("p_sort_fields"          , req.getSortFields());
		inParms.put("p_append_to_whr_clause" , req.getAppendToWhrClause());
		inParms.put("p_offset_row"           , req.getStart());
		inParms.put("p_number_of_rows"       , req.getLimit());
	
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID" , 0);
		inParms.put("SQL_MSGTXT", "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
}
