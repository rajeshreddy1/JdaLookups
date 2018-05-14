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

public class Usp_Generic_Sql_Result_Set  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Generic_Sql_Result_Set(JdbcTemplate jdbcTemplate, String action) {
		
		super(jdbcTemplate, "Usp_Generic_Sql_Result_Set");
		
		RowMapper rowMapper=null;
		
		switch (action) {
		
		case "nextmstevt" :
			rowMapper = new MstrEvntNumRowMapper();
			break;
			
		}
						
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_sql_statement" , Types.VARCHAR));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String sql_statement) {
		
		Map inParms = new HashMap();

		inParms.put("p_sql_statement"     , sql_statement);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
