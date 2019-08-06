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

import com.bedbath.jdalookups.model.MasterEvtGenerator;
import com.bedbath.jdalookups.model.SkuCount;

public class Usp_Next_Sequence_Number extends StoredProcedure{

	public Usp_Next_Sequence_Number(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Next_Sequence_Number");     
		declareParameter(new SqlParameter("p_seqname"      ,  Types.CHAR));
		
		declareParameter(new SqlInOutParameter("SQL_STATUS",  Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID" ,  Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT",  Types.VARCHAR));
		declareParameter(new SqlOutParameter("p_nextseqno" ,  Types.NUMERIC));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map<String, ? extends Object> getNextSeq(MasterEvtGenerator req) {
		
		Map inParms = new HashMap();
  
		inParms.put("p_seqname",   req.getSeqName());
		
		inParms.put("SQL_STATUS", 0);
		inParms.put("SQL_MSGID" , 0);
		inParms.put("SQL_MSGTXT", "");
		Map<String, ? extends Object> out = execute(inParms);				
		
		return out;		
		
	}

}
