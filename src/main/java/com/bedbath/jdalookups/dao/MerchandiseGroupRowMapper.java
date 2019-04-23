package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class MerchandiseGroupRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		MerchandiseGroupResultSetExtractor extractor = new MerchandiseGroupResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
