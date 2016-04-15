package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.SkuLookup;

public class SkuLookupResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		SkuLookup skuLookup = new SkuLookup();
		
		skuLookup.setSku(rs.getLong("INUMBR"));
		skuLookup.setSkuDescription(rs.getString("IDESCR"));
		skuLookup.setStatus(rs.getString("IDSCCD"));
		skuLookup.setRetailPrice(rs.getDouble("PMREGU"));
		skuLookup.setDepartment(rs.getInt("IDEPT"));
		skuLookup.setSubDepartment(rs.getInt("ISDEPT"));
		skuLookup.setClassa(rs.getInt("ICLAS"));
		skuLookup.setVendor(rs.getInt("ASNUM"));
		skuLookup.setVendorPartNumber(rs.getString("IVNDP#"));
		skuLookup.setMerchandiseGroup(rs.getString("IFINLN"));
		skuLookup.setColor(rs.getInt("ISCOLR"));
		skuLookup.setPriceGroup(rs.getString("ICORGP"));
		
		return skuLookup;		
	}				
	
}