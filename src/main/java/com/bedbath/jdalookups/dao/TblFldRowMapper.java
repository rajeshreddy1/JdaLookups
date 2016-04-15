package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class TblFldRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		TblFldResultSetExtractor extractor = new TblFldResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
