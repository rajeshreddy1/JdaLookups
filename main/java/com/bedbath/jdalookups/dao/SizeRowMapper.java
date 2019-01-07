package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class SizeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		SizeResultSetExtractor extractor = new SizeResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
