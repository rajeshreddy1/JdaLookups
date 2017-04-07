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

public class Usp_Bbsappvalu_Maintenance  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Bbsappvalu_Maintenance(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Bbsappvalu_Maintenance");
				
		declareParameter(new SqlParameter("p_action" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_application_Key" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_char_Value_1"    , Types.VARCHAR));
		declareParameter(new SqlParameter("p_char_Value_2"    , Types.VARCHAR));
		declareParameter(new SqlParameter("p_char_Value_3"    , Types.VARCHAR));
		declareParameter(new SqlParameter("p_numeric_Value_1" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_numeric_Value_2" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_numeric_Value_3" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_document_Path"   , Types.VARCHAR));
		declareParameter(new SqlParameter("p_note_1"          , Types.VARCHAR));
		declareParameter(new SqlParameter("p_note_2"          , Types.VARCHAR));
		declareParameter(new SqlParameter("p_seq_Name"        , Types.VARCHAR));
		declareParameter(new SqlParameter("p_user"            , Types.VARCHAR));

		declareParameter(new SqlOutParameter("p_count"        , Types.NUMERIC));
		declareParameter(new SqlOutParameter("p_nextSequence" , Types.NUMERIC));
		
		declareParameter(new SqlInOutParameter("SQL_STATUS"   , Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID"    , Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT"   , Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String action, String applicationKey, String charValue1, String charValue2, String charValue3, Long numValue1, Long numValue2, Long numValue3, String documentPath, String note1, String note2, String sequenceName, String user, String server) {
		
		Map inParms = new HashMap();
		
		inParms.put("p_action"          ,     action);   
		inParms.put("p_application_Key" ,     applicationKey);   
		inParms.put("p_char_Value_1"    ,     charValue1);   
		inParms.put("p_char_Value_2"    ,     charValue2); 
		inParms.put("p_char_Value_3"    ,     charValue3); 
		inParms.put("p_numeric_Value_1" ,     numValue1);  
		inParms.put("p_numeric_Value_2" ,     numValue2); 
		inParms.put("p_numeric_Value_3" ,     numValue3); 
		inParms.put("p_document_Path"   ,     documentPath);   
		inParms.put("p_note_1"          ,     note1);   
		inParms.put("p_note_2"          ,     note2);
		inParms.put("p_seq_Name"        ,     sequenceName);
		inParms.put("p_user"            ,     user);   
				
		inParms.put("p_count"           ,     0);
		inParms.put("p_nextSequence"    ,     0);   
				
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
	
}
