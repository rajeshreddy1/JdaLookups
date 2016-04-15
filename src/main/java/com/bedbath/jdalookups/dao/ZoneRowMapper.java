package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ZoneRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		ZoneResultSetExtractor extractor = new ZoneResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
