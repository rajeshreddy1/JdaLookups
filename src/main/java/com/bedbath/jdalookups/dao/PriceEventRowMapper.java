package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PriceEventRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PriceEventResultSetExtractor extractor = new PriceEventResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
