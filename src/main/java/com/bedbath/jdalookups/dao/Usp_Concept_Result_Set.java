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

public class Usp_Concept_Result_Set  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Concept_Result_Set(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Concept_Result_Set");
		
		RowMapper rowMapper = new ConceptRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_company_number" , Types.NUMERIC));      
		declareParameter(new SqlParameter("p_dns_name" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults() {
		
		Map inParms = new HashMap();

		inParms.put("p_company_number"    , 0);
		inParms.put("p_dns_name"          , "");
		inParms.put("p_offset_Row"        , 0);
		inParms.put("p_number_Of_Rows"    , 2000);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
