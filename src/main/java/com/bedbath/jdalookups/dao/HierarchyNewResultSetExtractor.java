package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.HierarchyNew;

public class HierarchyNewResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		HierarchyNew hierarchy = new HierarchyNew();
		
		hierarchy.setDepartment(rs.getInt("Department"));
		hierarchy.setDepartmentDescription(rs.getString("DepartmentName"));
		hierarchy.setSubDepartment(rs.getInt("SubDepartment"));
		hierarchy.setSubDepartmentDescription(rs.getString("SubDepartmentName"));
		hierarchy.setClassa(rs.getInt("Class"));
		hierarchy.setClassDescription(rs.getString("ClassName"));
		hierarchy.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		hierarchy.setExistenceColumn(rs.getDouble("EXISTCT"));		
		
		return hierarchy;		
	}				
	
}