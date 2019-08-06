package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.MasterEventHeader;

public class MasterEventHeaderResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		MasterEventHeader master = new MasterEventHeader();
		
		master.setMasterEventNumber(rs.getString("Master_Event_Number"));
		master.setEventDescription(rs.getString("Subject_Description"));
		master.setApplicationId(rs.getString("Application_Id"));
		master.setSequenceNumber(rs.getInt("Sequence_Number"));
		master.setEventType(rs.getString("Event_Type"));
		master.setStartDate(rs.getString("Start_Date"));
		master.setEndDate(rs.getString("End_Date"));
		master.setEventLevel(rs.getString("ChnZonStrBrkt"));
		master.setTotalRows(rs.getDouble("Total_Rows"));
		
		return master;		
	}				
	
}