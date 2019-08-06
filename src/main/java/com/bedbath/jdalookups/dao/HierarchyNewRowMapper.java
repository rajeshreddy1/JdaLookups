package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class HierarchyNewRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		HierarchyNewResultSetExtractor extractor = new HierarchyNewResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
