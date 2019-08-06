package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CampaignHeaderRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {				
		CampaignHeaderResultSetExtractor extractor = new CampaignHeaderResultSetExtractor();
	    return extractor.extractData(rs);
	}	
	
}
