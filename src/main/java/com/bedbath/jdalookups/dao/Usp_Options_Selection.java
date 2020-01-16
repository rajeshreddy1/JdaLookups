package com.bedbath.jdalookups.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.OptionsReq;


public class Usp_Options_Selection  extends StoredProcedure {

	public Usp_Options_Selection(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Options_Selection");
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST", new OptionsRecordResultSetExtractor()));
			
		declareParameter(new SqlParameter("p_action" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Field" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));	
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		declareParameter(new SqlParameter("p_search_option", Types.OTHER));

		compile();
		
	}
	
	public Map<String, ? extends Object> getResults(OptionsReq req) throws SQLException {
		
		Map<String, Object> inParms = new HashMap<String, Object>();
		Connection con = getJdbcTemplate().getDataSource().getConnection();
		
		inParms.put("p_action" , req.getAction());	
		inParms.put("p_sort_Field" , req.getSort_Field());
		inParms.put("p_offset_Row" , req.getStart());	
		inParms.put("p_number_Of_Rows" , req.getLimit());	
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		inParms.put("p_search_option" , con.createArrayOf("NUMERIC", req.getSearch_option().toArray()));
		
		Map<String, ? extends Object> out = execute(inParms);
		con.close();
		return out;		
		
	}
	
}
