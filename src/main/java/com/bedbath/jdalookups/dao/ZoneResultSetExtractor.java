package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Zone;

public class ZoneResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Zone zone = new Zone();
		
		zone.setZoneNumber(rs.getInt("ZONNUM"));
		zone.setZoneDescription(rs.getString("ZONNAM"));
		zone.setShortDescription(rs.getString("ZONSHT"));
		
		try{
			
			zone.setCountryCode(rs.getString("ZNCTRYCOD"));
			zone.setConversionRate(rs.getDouble("ZNCNVRAT"));
			zone.setCurrencyCode(rs.getString("ZNCURCOD"));
			
		} catch (Exception e) {
			
		}
						
		return zone;		
	}				
	
}