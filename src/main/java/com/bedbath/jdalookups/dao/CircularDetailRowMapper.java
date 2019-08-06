package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class CircularDetailRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		CircularDetailResultSetExtractor extractor = new CircularDetailResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
