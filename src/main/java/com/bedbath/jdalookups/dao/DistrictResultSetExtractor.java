package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.District;

public class DistrictResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		District district = new District();
		
		district.setDistrictNumber(rs.getInt("STRDST"));				
		district.setDistrictName(rs.getString("DISTRICT_NAME"));
		district.setShortName(rs.getString("DSTSHT"));
		district.setRegionNumber(rs.getInt("REGNUM"));
		
		return district;		
	}				
	
}