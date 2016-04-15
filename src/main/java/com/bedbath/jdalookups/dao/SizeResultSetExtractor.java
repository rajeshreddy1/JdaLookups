package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Size;

public class SizeResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Size size = new Size();
		
		size.setSizeCode(rs.getString("SIZCOD"));
		size.setSizeDescription(rs.getString("SIZDSC"));
		size.setSizeShortDescription(rs.getString("SIZSHT"));
		
		return size;		
	}				
	
}