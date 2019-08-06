package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.StoreBracketHeader;

public class Usp_Pace_Store_Bracket_Hdr_Selection  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Pace_Store_Bracket_Hdr_Selection(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Pace_Store_Bracket_Hdr_Selection");
		
		RowMapper rowMapper= new StoreBracketHeaderRowMapper();
			
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_store_brk_no" , Types.NUMERIC));      
		declareParameter(new SqlParameter("p_store_brk_desc" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_store_brk_src" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_store_brk_type" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(int bracketNumber, String bracketDescription, String bracketSource, String bracketType, String sortFields, int start, int limit) {
		
		Map inParms = new HashMap();

		inParms.put("p_store_brk_no"   , bracketNumber);
		inParms.put("p_store_brk_desc" , bracketDescription);
		inParms.put("p_store_brk_src"  , bracketSource);
		inParms.put("p_store_brk_type" , bracketType);
		inParms.put("p_sort_Fields"    , sortFields);
		
		inParms.put("p_offset_Row"     , start);
		inParms.put("p_number_Of_Rows" , limit);
		inParms.put("SQL_STATUS"       , 0);
		inParms.put("SQL_MSGID"        , 0);
		inParms.put("SQL_MSGTXT"       , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
		
}
