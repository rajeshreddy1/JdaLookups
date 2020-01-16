package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.OptionsRes;


public class OptionsRecordResultSetExtractor implements ResultSetExtractor<List<OptionsRes>> {
	
	public List<OptionsRes> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<OptionsRes> optsResSet = new ArrayList<OptionsRes>();
		
		while(rs.next()) {
			
			OptionsRes optionsRes= new OptionsRes();;
			optionsRes.setCtlqs(rs.getInt("CTLQS#"));
			optionsRes.setDesc(rs.getString("DESC"));
			optionsRes.setStatus(rs.getString("STATUS"));
			optionsRes.setNumVal(rs.getFloat("NUMERICVALUE"));
			optionsRes.setEditcde(rs.getString("EDITCDE"));
			optionsRes.setAlphaVal(rs.getString("ALPHAVALUE"));
			optionsRes.setTotal(rs.getInt("TOTAL_ROWS"));
			
			optsResSet.add(optionsRes);
		}
		
		return optsResSet;		
	}
}
