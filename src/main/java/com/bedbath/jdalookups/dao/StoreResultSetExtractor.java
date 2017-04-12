package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Store;

public class StoreResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Store store = new Store();
		
		store.setAddress1(rs.getString("STADD1"));
		store.setAddress2(rs.getString("STADD2"));
		store.setCity(rs.getString("STADD3"));
		store.setCompanyNumber(rs.getInt("STCMP"));
		store.setCountry(rs.getString("STCNTR"));
		store.setDistrict(rs.getInt("STRDST"));
		store.setName(rs.getString("STRNAM"));
		store.setPhoneNumber(rs.getLong("STPHON"));
		store.setRegion(rs.getInt("REGNUM"));
		store.setStateProvince(rs.getString("STPVST"));
		store.setStoreNumber(rs.getInt("STRNUM"));
		store.setZipCode(rs.getString("STZIP"));
		store.setZoneNumber(rs.getInt("ZONNUM"));
		store.setStoreOrOffice(rs.getString("STRHDO"));
		store.setStoreType(rs.getString("STRTYP"));
		
		try{
			store.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		} catch(Exception e) {
			
		}
		
		try{
			store.setExistenceColumn(rs.getDouble("EXISTCT"));
		} catch(Exception e) {
			
		}
		
		try{
			store.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		} catch(Exception e) {
			
		}		
		
		return store;		
	}				
	
}