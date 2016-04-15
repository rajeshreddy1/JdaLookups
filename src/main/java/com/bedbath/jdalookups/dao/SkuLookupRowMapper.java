package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class SkuLookupRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		SkuLookupResultSetExtractor extractor = new SkuLookupResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
