package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class HierarchyRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		HierarchyResultSetExtractor extractor = new HierarchyResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
