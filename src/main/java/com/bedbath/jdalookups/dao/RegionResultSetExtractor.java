package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Region;

public class RegionResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Region region = new Region();
		
		region.setRegionNumber(rs.getInt("REGNUM"));
		region.setRegionName(rs.getString("REGION_NAME"));
		region.setRegionManager(rs.getString("REGION_MANAGER"));
		region.setPhoneNumber(rs.getLong("REGPHN"));
		region.setShortName(rs.getString("REGSHT"));
		
		return region;
		
	}				
	
}