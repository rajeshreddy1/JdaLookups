package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.StoreBracketHeader;

public class StoreBracketHeaderResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		StoreBracketHeader bracket = new StoreBracketHeader();
		
		bracket.setBracketNumber(rs.getInt("Store_Bracket_Number"));
		bracket.setBracketDescription(rs.getString("Store_Bracket_Desc"));
		bracket.setDepartmentNumber(rs.getInt("Store_Bracket_Dept"));
		bracket.setSubDepartmentNumber(rs.getInt("Store_Bracket_SubDept"));
		bracket.setClassNumber(rs.getInt("Store_Bracket_Class"));
		bracket.setSource(rs.getString("Store_Bracket_Source"));
		bracket.setBracketType(rs.getString("Store_Bracket_Type"));
		
		return bracket;		
	}				
	
}