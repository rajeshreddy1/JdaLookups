package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ProductGroupHeaderRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		ProductGroupHeaderResultSetExtractor extractor = new ProductGroupHeaderResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
