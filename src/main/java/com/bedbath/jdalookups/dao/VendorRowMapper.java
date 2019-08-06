package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {				
		VendorResultSetExtractor extractor = new VendorResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
