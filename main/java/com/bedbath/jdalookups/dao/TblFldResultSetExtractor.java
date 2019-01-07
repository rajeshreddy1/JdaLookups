package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.TblFld;

public class TblFldResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		TblFld tblFld = new TblFld();
		
		tblFld.setFieldName(rs.getString("TBLNAM"));
		tblFld.setFieldValue(rs.getString("TBLVAL"));
		tblFld.setDescription(rs.getString("TBLDSC"));
		tblFld.setDefaultFlag(rs.getString("TBLDEF"));
		tblFld.setTotalRows(rs.getDouble("Total_Rows"));
		
		return tblFld;		
	}				
	
}