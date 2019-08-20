package com.bedbath.jdalookups.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.bedbath.jdalookups.model.SkuCount;

public class Usp_PmsPacDtl_Record_Count extends StoredProcedure{

	public Usp_PmsPacDtl_Record_Count(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_PmsPacDtl_Record_Count");
		     
		declareParameter(new SqlParameter("p_mevtno"     , Types.CHAR));
		declareParameter(new SqlParameter("p_seqno"      ,    Types.NUMERIC));
		declareParameter(new SqlParameter("p_appid"      ,    Types.CHAR));
		declareParameter(new SqlParameter("p_jdaevent"      , Types.CHAR));
		declareParameter(new SqlInOutParameter("SQL_STATUS",  Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID" ,  Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT",  Types.VARCHAR));
		declareParameter(new SqlOutParameter("p_recordcount", Types.NUMERIC));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map<String, ? extends Object> getCount(SkuCount req) {
		
		Map inParms = new HashMap();
  
		inParms.put("p_mevtno",   req.getMasterEvent());
		inParms.put("p_seqno",    req.getSequenceNumber());
		inParms.put("p_appid",    req.getAppId());
		inParms.put("p_jdaevent", req.getJdaEvent());
		
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID" , 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);				
		
		return out;		
		
	}

}
