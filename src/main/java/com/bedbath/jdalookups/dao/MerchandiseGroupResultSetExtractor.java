package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.MerchandiseGroup;

public class MerchandiseGroupResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		MerchandiseGroup merchandiseGroup = new MerchandiseGroup();
		
		merchandiseGroup.setMerchandiseGroupCode(rs.getString("IFINLN"));
		merchandiseGroup.setMerchandiseGroupDescription(rs.getString("IFLDSC"));
		
		try{
			merchandiseGroup.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		} catch(Exception e) {
			
		}
		
		try{
			merchandiseGroup.setExistenceColumn(rs.getDouble("EXISTCT"));
		} catch(Exception e) {
			
		}
		
		return merchandiseGroup;		
	}				
	
}