package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.MstrEvntNum;

public class MstrEvntNumResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		MstrEvntNum mstrEvntNum = new MstrEvntNum();
		
		mstrEvntNum.setMstrEvntNum(rs.getString("MSTEVT"));		
		
		return mstrEvntNum;		
	}				
	
}