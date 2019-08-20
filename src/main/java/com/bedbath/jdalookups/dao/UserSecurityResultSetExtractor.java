package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.BbsUsrmRes;

public class UserSecurityResultSetExtractor implements ResultSetExtractor<List<BbsUsrmRes>> {

public List<BbsUsrmRes> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<BbsUsrmRes> userResult = new ArrayList<BbsUsrmRes>();
		
		while(rs.next()) {
			
			BbsUsrmRes result= new BbsUsrmRes();
			result.setUser(rs.getString("USER_ID") != null ? rs.getString("USER_ID").trim() : "");
			result.setFirstName(rs.getString("FIRST_NAME") != null ? rs.getString("FIRST_NAME").trim() : "");
			result.setLastName(rs.getString("LAST_NAME") != null ? rs.getString("LAST_NAME").trim() : "");
			result.setFullName(rs.getString("FULL_NAME") != null ? rs.getString("FULL_NAME").trim() : "");
			result.setSecurityLevel(rs.getInt("SECURITY_LEVEL"));
			result.setTotalRows(rs.getInt("TOTAL_ROWS"));
			userResult.add(result);
		}
		
		return userResult;		
	}
}