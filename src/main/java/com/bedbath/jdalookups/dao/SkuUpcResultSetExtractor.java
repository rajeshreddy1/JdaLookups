package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.SkuOrUpcSearchRes;

public class SkuUpcResultSetExtractor implements ResultSetExtractor<List<SkuOrUpcSearchRes>> {

	public List<SkuOrUpcSearchRes> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<SkuOrUpcSearchRes> skus = new LinkedList<SkuOrUpcSearchRes>();
		
        while(rs.next()){  
        	SkuOrUpcSearchRes sku = new SkuOrUpcSearchRes();  
        	sku.setSku(rs.getLong("SKU"));
        	sku.setUpc(rs.getLong("UPC"));
        	sku.setSkuDescription(rs.getString("SKU_DESCRIPTION"));
        	sku.setDept(rs.getInt("DEPARTMENT_NUMBER"));
        	sku.setDeptDesc(rs.getString("DEPARTMENT_DESCRIPTION"));
        	sku.setSubDept(rs.getInt("SUB_DEPARTMENT_NUMBER"));
        	sku.setSubDeptDesc(rs.getString("SUB_DEPARTMENT_DESCRIPTION"));
        	sku.setClassa(rs.getInt("CLASS"));
        	sku.setClassaDesc(rs.getString("CLASS_DESCRIPTION"));
        	sku.setStatus(rs.getString("STATUS"));
        	sku.setRetailPrice(rs.getDouble("RETAIL"));
        	sku.setCurrCost(rs.getDouble("current_cost"));
        	sku.setBuyer(rs.getString("BUYER_NAME"));
        	sku.setPriceFamily(rs.getString("PRICE_FAMILY"));
        	sku.setVendor(rs.getInt("VENDOR_NUMBER"));
        	sku.setTotal(rs.getLong("TOTAL_ROWS"));
        	skus.add(sku);
        } 
		
		return skus;		
	}				
	
}