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

import com.bedbath.jdalookups.model.BbsAppValuReq;

public class Usp_BbsAppValu_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_BbsAppValu_Search(JdbcTemplate jdbcTemplate) {

		super(jdbcTemplate, "Usp_BbsAppValu_Search");

		declareParameter(new SqlReturnResultSet("RESULT_LIST", new BbsAppValuResultSetExtractor()));									
		declareParameter(new SqlParameter("p_app_Key" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_char_Val1" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_char_Val2" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_char_Val3" , Types.VARCHAR));		
		declareParameter(new SqlParameter("p_num_Val1" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_num_Val2" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_num_Val3" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_document_Path" , Types.VARCHAR));		
		declareParameter(new SqlParameter("p_note1" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_note2" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));		
		declareParameter(new SqlParameter("p_append_To_Whr_Clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_distinct_Result" , Types.CHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));

		compile();

	}

	public Map<String, ? extends Object> getResults(BbsAppValuReq req) throws SQLException {

		Map<String, Object> inParms = new HashMap<String, Object>();
		Connection con = getJdbcTemplate().getDataSource().getConnection();

		inParms.put("p_app_Key", req.getAppKey());               
		inParms.put("p_char_Val1", req.getCharVal1()); 
		inParms.put("p_char_Val2" , req.getCharVal2());
		inParms.put("p_char_Val3" , req.getCharVal3()); 
		inParms.put("p_num_Val1" , req.getNumVal1());
		inParms.put("p_num_Val2" , req.getNumVal2());
		inParms.put("p_num_Val3" , req.getNumVal3());
		inParms.put("p_document_Path" , req.getDocumentPath());
		inParms.put("p_note1" , req.getNote1());
		inParms.put("p_note2" , req.getNote2());  
		inParms.put("p_sort_Fields" , req.getSortFields());
		inParms.put("p_append_To_Whr_Clause" , req.getAppendToWhereClause());
		inParms.put("p_distinct_Result" , req.getDistinctResult());
		inParms.put("p_offset_Row" , req.getStart());
		inParms.put("p_number_Of_Rows" , req.getLimit());

		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");	
		Map<String, ? extends Object> out = execute(inParms);
		con.close();
		return out;		

	}

}
