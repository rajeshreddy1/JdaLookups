package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PriceGroupRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PriceGroupResultSetExtractor extractor = new PriceGroupResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
