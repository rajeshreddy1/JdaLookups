package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ConceptRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		ConceptResultSetExtractor extractor = new ConceptResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
