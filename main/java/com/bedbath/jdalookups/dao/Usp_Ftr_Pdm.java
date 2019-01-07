package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class Usp_Ftr_Pdm  extends StoredProcedure {

	public Usp_Ftr_Pdm(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Ftr_Pdm");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new PdmFtrAttrResultSetExtractor()));
		
		declareParameter(new SqlParameter("P_FEATURE_ATTRIBUTE", Types.VARCHAR));
		declareParameter(new SqlParameter("P_FEATURE_VALUE", Types.VARCHAR));
		declareParameter(new SqlParameter("P_OFFSET_ROW", Types.NUMERIC));
		declareParameter(new SqlParameter("P_NUMBER_OF_ROWS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));

		compile();
		
	}
	

	public Map<String, ? extends Object> getResults(String type, String description, String server, int start, int limit) {
				
		Map<String, Object> inParms = new HashMap<String, Object>();

		inParms.put("P_FEATURE_ATTRIBUTE", type);
		inParms.put("P_FEATURE_VALUE", description);
		inParms.put("P_OFFSET_ROW", start);
		inParms.put("P_NUMBER_OF_ROWS", limit);
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID", 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);
		
		return out;						
		
	}	
	
}
