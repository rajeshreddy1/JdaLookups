package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.CircularDetail;

public class CircularDetailResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		CircularDetail circular = new CircularDetail();
		
		circular.setCircularId(rs.getInt("CIRCULAR_ID"));
		circular.setCircularType(rs.getString("CIRCULAR_TYPE"));
		circular.setInHomeDate(rs.getString("CIRCULAR_IN_HOME_DATE"));		
		circular.setSku(rs.getLong("SKU"));
		circular.setSkuDescription(rs.getString("IDESCR"));
		circular.setTotalRows(rs.getDouble("TOTAL_ROWS"));
					
		return circular;		
	}				
	
}