package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class Usp_PRD_TYP  extends StoredProcedure {

	public Usp_PRD_TYP(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "USP_PRD_TYP");
		
		//declareParameter(new SqlReturnResultSet("RESULT_LIST", new EcomBrandResultSetExtractor()));
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new PdmFtrAttrResultSetExtractor()));
		
		declareParameter(new SqlParameter("p_Feature_Value", Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row", Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));

		compile();

			
	}
	

	public Map<String, ? extends Object> getResults(String description, String server, int start, int limit) {
				
		Map<String, Object> inParms = new HashMap<String, Object>();

		inParms.put("p_Feature_Value", description);
		inParms.put("p_offset_Row", start);
		inParms.put("p_number_Of_Rows", limit);
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID", 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);
		
		return out;											
		
	}	
	
}
