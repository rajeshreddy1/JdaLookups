package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.BbsUsrmUser;

public class BbsUsrmUserResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		BbsUsrmUser user = new BbsUsrmUser();
		
		user.setUser(rs.getString("USUSR"));		
		user.setFirstName(rs.getString("USFNM"));			
		user.setLastName(rs.getString("USLNM"));			
		user.setFullName(rs.getString("USFNM") + " " + rs.getString("USLNM"));	
				
		try{			
			user.setStore(rs.getInt("USSTR"));			
		} catch(Exception e) {			
		}
		
		try{			
			user.setLevel(rs.getInt("USLVL"));			
		} catch(Exception e) {			
		}
		
		try{			
			user.setSystemId(rs.getString("USSID"));			
		} catch(Exception e) {			
		}
		
		try{			
			user.setTotalRows(rs.getDouble("TOTAL_ROWS"));			
		} catch(Exception e) {			
		}
		
		return user;
	}
	
}