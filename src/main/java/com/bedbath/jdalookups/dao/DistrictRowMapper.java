package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DistrictRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		DistrictResultSetExtractor extractor = new DistrictResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
