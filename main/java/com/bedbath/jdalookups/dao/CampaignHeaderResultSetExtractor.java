package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Campaign;
import com.bedbath.jdalookups.model.Vendor;


public class CampaignHeaderResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Campaign campaigns = new Campaign();		

		campaigns.setCampaignId(rs.getInt("EVENT_GROUP_ID"));
		campaigns.setCampaignName(rs.getString("EVENT_GROUP_NAME"));
		campaigns.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		
		return campaigns;
		
	}				
	
}
