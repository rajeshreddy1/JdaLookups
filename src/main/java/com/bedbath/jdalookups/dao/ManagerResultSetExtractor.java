package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Manager;

public class ManagerResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Manager manager = new Manager();
		
		manager.setTitle(rs.getString("TITLE"));
		manager.setManager(rs.getString("MANAGER"));
		
		return manager;		
	}				
	
}