package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ManagerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		ManagerResultSetExtractor extractor = new ManagerResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
