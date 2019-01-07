package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.CircularHeader;

public class CircularHeaderResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		CircularHeader circular = new CircularHeader();
		
		circular.setCircularId(rs.getInt("CIRCULAR_ID"));
		circular.setCircularType(rs.getString("CIRCULAR_TYPE"));
		circular.setCircularName(rs.getString("CIRCULAR_NAME"));
		circular.setInHomeDate(rs.getString("CIRCULAR_IN_HOME_DATE"));		
		circular.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		
		return circular;		
	}				
	
}