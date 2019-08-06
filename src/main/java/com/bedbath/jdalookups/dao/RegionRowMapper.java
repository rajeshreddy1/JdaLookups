package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class RegionRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		RegionResultSetExtractor extractor = new RegionResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
