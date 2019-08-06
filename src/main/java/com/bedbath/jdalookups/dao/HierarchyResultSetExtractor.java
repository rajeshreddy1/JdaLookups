package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Hierarchy;

public class HierarchyResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Hierarchy hierarchy = new Hierarchy();
		
		hierarchy.setDepartment(rs.getInt("IDEPT"));
		hierarchy.setSubDepartment(rs.getInt("ISDEPT"));
		hierarchy.setClassa(rs.getInt("ICLAS"));
		hierarchy.setHierarchyDescription(rs.getString("DPTNAM"));
				
		return hierarchy;		
	}				
	
}