package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.PriceGroup;

public class PriceGroupResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		PriceGroup priceGroup = new PriceGroup();
		
		priceGroup.setPriceGroupCode(rs.getString("CORGRP"));
		priceGroup.setPriceGroupDescription(rs.getString("CORDSC"));
			
		try{
			priceGroup.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		} catch(Exception e) {
			
		}
		
		try{
			priceGroup.setExistenceColumn(rs.getDouble("EXISTCT"));
		} catch(Exception e) {
			
		}
		
		return priceGroup;		
	}				
	
}
