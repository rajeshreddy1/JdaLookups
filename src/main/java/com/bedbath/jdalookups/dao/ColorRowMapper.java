package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ColorRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		ColorResultSetExtractor extractor = new ColorResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
