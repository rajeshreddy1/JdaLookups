package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class MasterEventHeaderRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		MasterEventHeaderResultSetExtractor extractor = new MasterEventHeaderResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
