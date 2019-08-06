package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Buyer;

public class BuyerResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Buyer buyer = new Buyer();
		
		buyer.setBuyerNumber(rs.getString("BYRNUM"));
		buyer.setBuyerName(rs.getString("BYRNAM"));
		buyer.setStartDate(rs.getLong("BYRSDT"));
		buyer.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		
		return buyer;
	}
	
}