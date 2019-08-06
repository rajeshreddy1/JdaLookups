package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.WebAppStatusRes;

public class WebAppStatusResultSetExtractor implements ResultSetExtractor<List<WebAppStatusRes>> {

public List<WebAppStatusRes> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<WebAppStatusRes> webStatus = new ArrayList<WebAppStatusRes>();
		
		while(rs.next()) {
			
			WebAppStatusRes status= new WebAppStatusRes();
			status.setEffectiveFrom(rs.getString("EFFECTIVE_FROM"));
			status.setEffectiveTo(rs.getString("EFFECTIVE_TO"));
			status.setPropertyValue(rs.getString("PROPERTY_VALUE"));
			webStatus.add(status);
		}
		
		return webStatus;		
	}
}
