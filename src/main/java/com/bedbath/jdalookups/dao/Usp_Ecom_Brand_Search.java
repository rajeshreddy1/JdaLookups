package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class Usp_Ecom_Brand_Search  extends StoredProcedure {

	public Usp_Ecom_Brand_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Ecom_Brand_Search");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new EcomBrandResultSetExtractor()));
		
		declareParameter(new SqlParameter("P_BRAND_DESCRIPTION", Types.VARCHAR));
		declareParameter(new SqlParameter("P_EXISTENCE_COLUMN", Types.VARCHAR));
		declareParameter(new SqlParameter("P_APPEND_TO_WHR_CLAUSE", Types.VARCHAR));
		declareParameter(new SqlParameter("P_OFFSET_ROW", Types.NUMERIC));
		declareParameter(new SqlParameter("P_NUMBER_OF_ROWS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));

		compile();
		
	}
	

	public Map<String, ? extends Object> getResults(String type, String description, String server, int start, int limit) {
				
		Map<String, Object> inParms = new HashMap<String, Object>();

		inParms.put("P_BRAND_DESCRIPTION", description);
		inParms.put("P_EXISTENCE_COLUMN", "");
		inParms.put("P_APPEND_TO_WHR_CLAUSE", "");
		inParms.put("P_OFFSET_ROW", start);
		inParms.put("P_NUMBER_OF_ROWS", limit);
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID", 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);
		
		return out;						
		
	}	
	
}
