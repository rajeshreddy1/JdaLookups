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

public class Usp_Get_Jda_InvCal  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Get_Jda_InvCal(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Get_Jda_InvCal");
				
		declareParameter(new SqlParameter("p_input_Date" , Types.VARCHAR));      		
		
		declareParameter(new SqlOutParameter("o_current_Date" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Fiscal_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Fiscal_Period" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Fiscal_Week_Of_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Fiscal_Week_Of_Period" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Fiscal_Day_Of_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Day_Of_Week" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_current_Long_Form" , Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("o_previous_Date" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Fiscal_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Fiscal_Period" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Fiscal_Week_Of_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Fiscal_Week_Of_Period" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Fiscal_Day_Of_Year" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Day_Of_Week" , Types.NUMERIC));
		declareParameter(new SqlOutParameter("o_previous_Long_Form" , Types.VARCHAR));
		 		 		 		
		declareParameter(new SqlInOutParameter("SQL_STATUS", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGID", Types.NUMERIC));
		declareParameter(new SqlInOutParameter("SQL_MSGTXT", Types.VARCHAR));
		
		compile();
		
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	public Map getResults(String inputDate, String server) {
		
		Map inParms = new HashMap();

		inParms.put("p_input_Date"         , inputDate);

		inParms.put("SQL_STATUS"          , 0);
		inParms.put("SQL_MSGID"           , 0);
		inParms.put("SQL_MSGTXT"          , "");
		Map out = execute(inParms);
		
		return out;		
		
	}
	
}
