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

public class Usp_Pace_Evtmgr_Evtsum_Selection  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Pace_Evtmgr_Evtsum_Selection(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Pace_Evtmgr_Evtsum_Selection");
		
		RowMapper rowMapper= new CampaignHeaderRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_evtgrp_id" , Types.NUMERIC));      
		declareParameter(new SqlParameter("p_evtgrp_name" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_sort_Field" , Types.VARCHAR));
		declareParameter(new SqlParameter("p_offset_Row" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_number_Of_Rows" , Types.NUMERIC));		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(int campaignId, String campaignName, String sortField, int start, int limit) {
		
		Map inParms = new HashMap();

		inParms.put("p_evtgrp_id"         , campaignId);
		inParms.put("p_evtgrp_name"      , campaignName);
		inParms.put("p_sort_Field"        , sortField);
		inParms.put("p_offset_Row"         , start);
		inParms.put("p_number_Of_Rows"    , limit);
		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
