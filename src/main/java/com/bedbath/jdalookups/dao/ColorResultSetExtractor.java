package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Color;

public class ColorResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Color color = new Color();
		
		color.setColorCode(rs.getInt("COLCOD"));
		color.setColorDescription(rs.getString("COLDSC"));
		
		try {
			color.setShortDescription(rs.getString("COLSHT"));	
		} catch(Exception e) {
			
		}
						
		try{
			color.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		} catch(Exception e) {
			
		}
		
		try{
			color.setExistenceColumn(rs.getDouble("EXISTCT"));
		} catch(Exception e) {
			
		}
		
		return color;		
	}				
	
}