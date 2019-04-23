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

public class Usp_Pace_Master_Event_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Pace_Master_Event_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Pace_Master_Event_Search");
		
		RowMapper rowMapper= new MasterEventHeaderRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_master_Event" , Types.VARCHAR));      
		declareParameter(new SqlParameter("p_event_Description" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_start_Date" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_event_Types" , Types.CHAR));
		declareParameter(new SqlParameter("p_application_Id" , Types.CHAR));
		declareParameter(new SqlParameter("p_sort_Fields" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_append_To_Whr_Clause" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String masterEventNumber, String eventDescription, String startDate, String eventTypes, String applicationId, String sortFields, String appendToWhereClause, int start, int limit) {
		
		Map inParms = new HashMap();

		inParms.put("p_master_Event"         , masterEventNumber);
		inParms.put("p_event_Description"    , eventDescription);
		inParms.put("p_start_Date"           , startDate);
		inParms.put("p_event_Types"          , eventTypes);
		inParms.put("p_application_Id"       , applicationId);
		inParms.put("p_sort_Fields"          , sortFields);
		inParms.put("p_append_To_Whr_Clause" , appendToWhereClause);
		
		inParms.put("p_offset_Row"           , start);
		inParms.put("p_number_Of_Rows"       , limit);
		inParms.put("SQL_STATUS"             , 0);
		inParms.put("SQL_MSGID"              , 0);
		inParms.put("SQL_MSGTXT"             , "");		
		Map out = execute(inParms);
		
		return out;		
		
	}
		
}
