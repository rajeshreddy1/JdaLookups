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

public class Usp_Jda_Code_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Jda_Code_Search(JdbcTemplate jdbcTemplate, String action) {
		
		super(jdbcTemplate, "Usp_Jda_Code_Search");
		
		RowMapper rowMapper = null;
		
		switch(action) {
		
		case "color" :
			rowMapper = new ColorRowMapper();
			break;
		case "size" :
			rowMapper = new SizeRowMapper();
			break;
		case "pricegroup" :
			rowMapper = new PriceGroupRowMapper();
			break;
		case "pattern" :
			rowMapper = new MerchandiseGroupRowMapper();
			break;
		}
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_code_type" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_code" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_description" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_existence_Column" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_append_To_Whr_Clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String codeType, String code, String codeDescription, String sortFields, String existenceColumn, String appendToWhereClause, int start, int limit) {
		
		Map inParms = new HashMap();
		
		inParms.put("p_code_type"            , codeType); 
		inParms.put("p_code"                 , code);
		inParms.put("p_description"          , codeDescription);												
		inParms.put("p_sort_Fields"          , sortFields);
		inParms.put("p_existence_Column"     , existenceColumn);
		inParms.put("p_append_To_Whr_Clause" , appendToWhereClause);
		
		inParms.put("p_offset_Row"        , start);
		inParms.put("p_number_Of_Rows"    , limit);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
	
}
