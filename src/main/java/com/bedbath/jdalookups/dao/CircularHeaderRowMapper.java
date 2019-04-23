package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class CircularHeaderRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		CircularHeaderResultSetExtractor extractor = new CircularHeaderResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
