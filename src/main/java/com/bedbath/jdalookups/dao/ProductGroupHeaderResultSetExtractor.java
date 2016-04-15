package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.ProductGroupHeader;

public class ProductGroupHeaderResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		ProductGroupHeader productGroupHeader = new ProductGroupHeader();
		
		productGroupHeader.setGroupNumber(rs.getInt("PRODUCT_GROUP_NUMBER"));
		productGroupHeader.setGroupDescription(rs.getString("PRODUCT_GROUP_DESCRIPTION"));
		productGroupHeader.setGroupTypeValue(rs.getString("TYPE"));
		productGroupHeader.setGroupTypeDescription(rs.getString("TYPEDESCRIPTION"));
		productGroupHeader.setGroupStatus(rs.getString("STATUS"));
		productGroupHeader.setGroupCreateDate(rs.getDate("CREATE_DATE_TIME"));
		
		return productGroupHeader;		
	}				
	
}
