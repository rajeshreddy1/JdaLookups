package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Vendor;

public class VendorResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Vendor vendor = new Vendor();
		
		vendor.setVendorNumber(rs.getInt("ASNUM"));
		vendor.setVendorName(rs.getString("ASNAME"));
		vendor.setBuyerNumber(rs.getString("ASBUYR"));
		vendor.setVendorType(rs.getString("ASTYPE"));
				
		return vendor;
		
	}				
	
}
