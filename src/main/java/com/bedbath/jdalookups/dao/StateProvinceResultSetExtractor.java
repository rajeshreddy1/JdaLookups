package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.StateProvince;

public class StateProvinceResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		StateProvince state = new StateProvince();
		
		state.setCode(rs.getString("PRCODE"));
		state.setDescription(rs.getString("PRNAME"));
		state.setCountry(rs.getString("PRCNTR"));		
		
		return state;		
	}				
	
}