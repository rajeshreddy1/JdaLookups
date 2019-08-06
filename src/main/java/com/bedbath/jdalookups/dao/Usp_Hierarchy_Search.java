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

import com.bedbath.jdalookups.model.HierarchyNew;

public class Usp_Hierarchy_Search  extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	public Usp_Hierarchy_Search(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "Usp_Hierarchy_Search");
		
		RowMapper rowMapper = new HierarchyNewRowMapper();
		
		declareParameter(new SqlReturnResultSet("RESULT_LIST",rowMapper));
		
		declareParameter(new SqlParameter("p_action" , Types.CHAR));      
		declareParameter(new SqlParameter("p_department_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_sub_department_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_class_Number" , Types.NUMERIC));
		declareParameter(new SqlParameter("p_hierarchy_Name" , Types.VARCHAR));
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
	public Map getResults(String action, int departmentNumber, int subDepartmentNumber, int classNumber, String hierarchyName, String sortFields, String existenceColumn, String appendToWhrClause, int start, int limit) {
		
		Map inParms = new HashMap();

		inParms.put("p_action"                , action);  
		inParms.put("p_department_Number"     , departmentNumber);
		inParms.put("p_sub_department_Number" , subDepartmentNumber);
		inParms.put("p_class_Number"          , classNumber);
		inParms.put("p_hierarchy_Name"        , hierarchyName);
		inParms.put("p_sort_Fields"           , sortFields);
		inParms.put("p_existence_Column"     , existenceColumn);
		inParms.put("p_append_To_Whr_Clause" , appendToWhrClause);
		inParms.put("p_offset_Row"           , start);
		inParms.put("p_number_Of_Rows"       , limit);
		inParms.put("SQL_STATUS"             , 0);
		inParms.put("SQL_MSGID"              , 0);
		inParms.put("SQL_MSGTXT"             , "");
		Map out = execute(inParms);				
		
		return out;		
		
	}
	
}
