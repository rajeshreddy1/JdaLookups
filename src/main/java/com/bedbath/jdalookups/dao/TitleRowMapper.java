package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class TitleRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		TitleResultSetExtractor extractor = new TitleResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
