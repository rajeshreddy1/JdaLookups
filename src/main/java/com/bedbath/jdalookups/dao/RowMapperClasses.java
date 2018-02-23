package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperClasses {

}

class MstrEvntNumRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		
		MstrEvntNumResultSetExtractor extractor = new MstrEvntNumResultSetExtractor();
		return extractor.extractData(rs);
		
	}
	
}
class BuyerRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		
		BuyerResultSetExtractor extractor = new BuyerResultSetExtractor();
		return extractor.extractData(rs);
		
	}
	
}

class MixMatchCategoryRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		
		MixMatchCategoryResultSetExtractor extractor = new MixMatchCategoryResultSetExtractor();
		return extractor.extractData(rs);
		
	}
	
}